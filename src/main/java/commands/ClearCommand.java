package commands;

import collection.CollectionOfMusicBand;

public class ClearCommand extends Command{
    public ClearCommand(String name, String description, CollectionOfMusicBand collectionOfMusicBand) {
        super(name, description, collectionOfMusicBand);
    }

    @Override
    public void execute() {
        if (collectionOfMusicBand.getNumberOfCardsOfCards() == 0) {
            System.out.println("Collection is already empty");
        } else {
            collectionOfMusicBand.getCollectionOfCards().clear();
            System.out.println("Collection is empty");
        }
    }
}
















