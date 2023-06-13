package cmd;

import exceptions.ExitException;

import java.io.File;

public class FileManager {
    public FileManager() {}

    public File getFile() throws ExitException{
        String fileName = System.getenv("class_path");
        if (fileName == null || fileName.isEmpty()) {
            throw new ExitException("File not found");
        }
        return new File(fileName);

    }
}
