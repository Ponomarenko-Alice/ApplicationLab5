import java.io.*;

public class TestReader {
    public void a() {
        try (BufferedReader in = new BufferedReader(new FileReader("collection.csv"));
             BufferedWriter out = new BufferedWriter(new FileWriter("out.csv"))) {
            String line;
            while ((line = in.readLine()) != null) {
                out.write(line);
                out.newLine();
            }
            out.flush();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
