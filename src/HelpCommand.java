import java.util.Map;

public class HelpCommand extends Command{

    public HelpCommand(String name, String description) {
        super(name, description);

    }
    public void execute() {
        Invoker invoker = new Invoker();
        for (Map.Entry<String, Command> entry : invoker.getCommandSet().entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
