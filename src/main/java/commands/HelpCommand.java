package commands;

import collection.CollectionOfMusicBand;

import java.util.Map;

public class HelpCommand extends Command {


    public HelpCommand(String name, String description, CollectionOfMusicBand collectionOfMusicBand, CommandSet commands, String... params) {
        super(name, description, collectionOfMusicBand, commands, params);
    }

    @Override
    public void execute() {
        System.out.println("-AVAILABLE COMMANDS-");
        for (Map.Entry<String, Command> set : commands.getCommandSet().entrySet()) {
            System.out.println(set.getValue().getDescriptionCommand());
        }
    }
}
