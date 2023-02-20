import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class OpenFile implements Command{
    MetadataFile metadataFile;
    public OpenFile(MetadataFile metadataFile) {
        this.metadataFile = metadataFile;
    }
    @Override
    public Scanner execute() throws IOException {
        this.metadataFile.open();
        Scanner in = new Scanner(Path.of(metadataFile.getName()), StandardCharsets.UTF_8);
        return in;
    }


}
