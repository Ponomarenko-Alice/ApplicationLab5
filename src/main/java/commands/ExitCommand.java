package commands;

import collection.CollectionOfMusicBand;

public class ExitCommand extends Command {
    public ExitCommand(String name, String description, CollectionOfMusicBand collectionOfMusicBand, CommandSet commands, String... params) {
        super(name, description, collectionOfMusicBand, commands, params);
    }

    @Override
    public void execute() throws ExitException {
        System.out.println("Bye :З");
        throw new ExitException("Bye :З");
    }
}
