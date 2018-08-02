package integrator;

import integrator.Api.ApiCaller;
import integrator.Model.RootData;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

public class Processor extends Thread {

    private final WatchService watcher;
    private final Path dir;
    private final static Logger logger = Logger.getLogger(Main.class.getName());

    /**
     * Creates a WatchService and registers the given directory
     */
    protected Processor(Path dir) throws IOException {
        this.watcher = FileSystems.getDefault().newWatchService();
        dir.register(watcher, ENTRY_CREATE);
        this.dir = dir;
    }

    public void run() {
        processEvents();
    }

    /**
     * Process all events for the key queued to the watcher.
     */
    protected void processEvents() {
        MainParser mainParser = new MainParser();
        for (; ; ) {

            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                logger.log(Level.WARNING,x.getMessage());
                return;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind kind = event.kind();

                if (kind == OVERFLOW) {
                    continue;
                }
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path filename = ev.context();
                Path child = dir.resolve(filename);
                String extension = getFileExtension(child.toFile());
                mainParser.setExtension(extension);
                RootData jsonMarketObject = mainParser.execute(child.toAbsolutePath());
                new ApiCaller(jsonMarketObject).callProduct();

            }
            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
    }


    /**
     * @param file which will be processing
     * @return extension of processed file
     */
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        final int i = fileName.lastIndexOf('.');
        return Optional.of(fileName)
                .filter(s -> i > 0 && !s.substring(i + 1).isEmpty())
                .map(s -> s.substring(i + 1))
                .orElseThrow(() -> new IllegalArgumentException("File extension can not be empty"));
    }

}
