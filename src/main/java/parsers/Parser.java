package parsers;

import integrator.Model.RootData;

import java.nio.file.Path;

public interface Parser {

    RootData parse(Path pathToFile);
}
