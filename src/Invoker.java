import java.util.LinkedHashMap;

public class Invoker {

    public LinkedHashMap<String, Command> getCommandSet() {
        LinkedHashMap<String, Command> commands = new LinkedHashMap<>();
        commands.put("help", new HelpCommand(" help ","shows help for available commands." ));
        commands.put("info", new InfoCommand(" info ", "gets information about the type of collection."));

        return commands;

    }

}