package commands;

import collection.CollectionController;

import java.util.Map;

public class HelpCommand extends Command {


    public HelpCommand(String name, String description, CollectionController collectionController, CommandSet commands, String... params) {
        super(name, description, collectionController, commands, params);
    }

    @Override
    public void execute() {
        System.out.println("-AVAILABLE COMMANDS-");
        for (Map.Entry<String, Command> set : commands.getCommandSet().entrySet()) {
            System.out.println(set.getValue().getDescriptionCommand());
        }
    }
}
