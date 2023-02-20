import java.io.IOException;
import java.util.Scanner;

public interface Command {
    Scanner execute() throws IOException;

}
