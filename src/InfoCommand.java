
import java.util.Map;

public class InfoCommand extends Command {
    public InfoCommand(String name, String description) {
        super(name, description);
    }
    Invoker invoker = new Invoker();


    @Override
    public void execute() {
        for(Map.Entry<String, Command> set : invoker.getCommandSet().entrySet()) {
            System.out.println(set.getValue().getDescription());
        }
    }
}
