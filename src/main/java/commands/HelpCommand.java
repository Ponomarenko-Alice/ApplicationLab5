package commands;

import java.util.Map;

public class HelpCommand extends Command {

    public HelpCommand(String name, String description) {
        super(name, description);
    }

    CommandSet cs = new CommandSet();

    @Override
    public void execute() {
        System.out.println("-AVAILABLE COMMANDS-");
        for (Map.Entry<String, Command> set : cs.getCommandSet().entrySet()) {
            System.out.println(set.getValue().getDescription());
        }
    }
}
