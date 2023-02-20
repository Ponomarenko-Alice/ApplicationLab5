import java.io.IOException;
import java.util.Scanner;

public class ParserFromFileToCollection {
    Reader reader;
    public ParserFromFileToCollection(Reader reader) {
        this.reader = reader;
    }

    public void execute() throws IOException {
        Scanner sc = reader.execute();
        while (sc.hasNextLine()) {
            String[] data = sc.nextLine().split(";");
            for (String x: data) {
                // fill collection
                System.out.println(x);
            }
        }
    }
}
