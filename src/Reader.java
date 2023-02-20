import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class Reader {
    private String fileName;

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public Scanner execute() throws IOException {
        Scanner file = new Scanner(Path.of(this.fileName), StandardCharsets.UTF_8);
        return file;
    }

}
