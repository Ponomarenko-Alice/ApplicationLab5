package commands;

import collection.CollectionOfMusicBand;

import java.util.Map;

public class HelpCommand extends Command {


    public HelpCommand(CollectionOfMusicBand collectionOfMusicBand, CommandSet commands, String... params) {
        super(collectionOfMusicBand, commands, params);
    }

    @Override
    public void execute() {
        System.out.println("-AVAILABLE COMMANDS-");
        for (Map.Entry<String, Command> set : commands.getCommandSet().entrySet()) {
            System.out.println(set.getValue().getDescriptionCommand());
        }
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return " show help for available commands.";
    }
}
