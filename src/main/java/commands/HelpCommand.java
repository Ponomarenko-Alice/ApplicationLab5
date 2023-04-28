package commands;
import collection.CollectionOfMusicBand;

import java.util.Map;

public class HelpCommand extends Command {

    public HelpCommand(String name, String description, CollectionOfMusicBand collectionOfMusicBand) {
        super(name, description, collectionOfMusicBand);
    }

    CommandSet cs = new CommandSet(collectionOfMusicBand);

    @Override
    public void execute() {
        System.out.println("-AVAILABLE COMMANDS-");
        for (Map.Entry<String, Command> set : cs.getCommandSet().entrySet()) {
            System.out.println(set.getValue().getDescription());
        }
    }
}
