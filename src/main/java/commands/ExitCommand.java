package commands;

import collection.CollectionOfMusicBand;

public class ExitCommand extends Command {
    public ExitCommand(CollectionOfMusicBand collectionOfMusicBand, CommandSet commands, String... params) {
        super(collectionOfMusicBand, commands, params);
    }

    @Override
    public void execute() {
        System.out.println("Bye :З");
        System.exit(0);
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return " exit the program";
    }
}
