package commands;

import collection.CollectionOfMusicBand;

public class ClearCommand extends Command {

    public ClearCommand(CollectionOfMusicBand collectionOfMusicBand, String... params) {
        super(collectionOfMusicBand, params);
    }

    @Override
    public void execute() {
        if (collectionOfMusicBand.getNumberOfCardsOfCards() == 0) {
            System.out.println("Collection is already empty");
        } else {
            collectionOfMusicBand.getCollectionOfCards().clear();
            System.out.println("Collection is empty now");
        }
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return " delete all music bands from collection.";
    }
}
















