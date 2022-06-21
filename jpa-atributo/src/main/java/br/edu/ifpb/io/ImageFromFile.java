package br.edu.ifpb.io;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageFromFile implements Serializable {
    private final Path path;
    public ImageFromFile(String path) {
        this(Paths.get(path));
    }
    public ImageFromFile(Path path) {
        this.path = path;
    }
    public byte[] toBytes() throws IOException {
        return Files.readAllBytes(path);
    }

}
