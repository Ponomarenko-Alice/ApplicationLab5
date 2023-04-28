package commands;

import collection.CollectionOfMusicBand;


public class InfoCommand extends Command {
    public InfoCommand(String name, String description) {
        super(name, description);
    }
    CollectionOfMusicBand collectionOfMusicBand = new CollectionOfMusicBand();

    @Override
    public void execute() {
        System.out.println("-INFORMATION ABOUT COLLECTION-");
        System.out.println("Type of collection: " + collectionOfMusicBand.getName());
        System.out.println("Date of initialization : " + "----");
        System.out.println("Number of card : " + collectionOfMusicBand.getNumberOfCardsOfCards());

    }


}
