package parsers;

import integrator.Main;
import integrator.Model.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;


public class XML implements Parser {
    private final static Logger logger = Logger.getLogger(Main.class.getName());

    @Override
    public RootData parse(Path pathToFile) {
        RootData rootData = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(RootData.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            rootData = (RootData) jaxbUnmarshaller.unmarshal(pathToFile.toFile());

        } catch (Exception e) {
            logger.log(Level.WARNING,e.toString());
        }

        return rootData;
    }
}
