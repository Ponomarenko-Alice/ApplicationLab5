import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("jfjfjfjfj");
        ParserFromFileToCollection p = new ParserFromFileToCollection(new Reader("collection.csv"));
        p.execute();
    }
}