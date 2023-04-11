
public class Main {
    public static void main(String[] args) {

        InfoCommand infoCommand = new InfoCommand(" ", "");
        infoCommand.execute();

        TestReader reader = new TestReader();
        reader.a();

        HelpCommand helpCommand = new HelpCommand("", "");
        helpCommand.execute();
    }
}