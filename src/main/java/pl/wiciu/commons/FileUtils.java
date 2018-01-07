package pl.wiciu.commons;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {

    public InputStream loadFileFromClasspath(String fileName) {
        return this.getClass().getResourceAsStream(fileName);
    }

    public List<String> loadFileByLineFromPath(String path, String fileName) throws IOException {
        Path fullPath = Paths.get(path, fileName);
        return Files.lines(fullPath)
                .collect(Collectors.toList());
    }

    public List<Path> listFilesInPath(String path) throws IOException {
        return Files.list(Paths.get(path)).collect(Collectors.toList());
    }

}
