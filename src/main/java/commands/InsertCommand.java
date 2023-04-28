package commands;

import collection.CollectionOfMusicBand;

public class InsertCommand extends Command{
    public InsertCommand(String name, String description, CollectionOfMusicBand collectionOfMusicBand) {
        super(name, description, collectionOfMusicBand);
    }

    @Override
    public void execute() {

    }
}
