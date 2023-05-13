package commands;

import collection.CollectionOfMusicBand;

import java.util.Map;

public class HelpCommand extends Command {


    public HelpCommand(CollectionOfMusicBand collectionOfMusicBand, String... params) {
        super(collectionOfMusicBand, params);
    }

    @Override
    public void execute() {
        System.out.println("-AVAILABLE COMMANDS-");
        совсем не думается сейчас, да?)))
        максимально ))) )
        for (Map.Entry<String, Command> set : cs.getCommandSet().entrySet()) {
            System.out.println(set.getValue().getDescriptionCommand());
        }
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return " shows help for available commands.";
    }
}
