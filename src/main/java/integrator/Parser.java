package integrator;

import integrator.Model.RootData;
import lombok.Setter;

import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

enum Extensions {
    XML {
        @Override
        public RootData parse(Path pathToFile) {

            return new parsers.XML().parse(pathToFile);
        }
    };

    public abstract RootData parse(Path pathToFile);
}

@Setter
class MainParser {

    private final static Logger logger = Logger.getLogger(Main.class.getName());

    private String extension;

    RootData execute(Path pathToFile) {
        RootData jsonMarketObject = null;
        try {
            Extensions convertToJson = Extensions.valueOf(this.extension.toUpperCase());
            jsonMarketObject = convertToJson.parse(pathToFile);

        } catch (IllegalArgumentException ex) {
            System.err.println("invalid extension of file!");
            logger.log(Level.WARNING, "invalid extension of file!");
        }

        return jsonMarketObject;
    }
}
