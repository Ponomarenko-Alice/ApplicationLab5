package commands;

import collection.CollectionOfMusicBand;


public class InfoCommand extends Command {

    public InfoCommand(CollectionOfMusicBand collectionOfMusicBand, CommandSet commands) {
        super(collectionOfMusicBand, commands);
    }

    @Override
    public void execute() {
        System.out.println("-INFORMATION ABOUT COLLECTION-");
        System.out.println("Type of collection: " + collectionOfMusicBand.getName());
        System.out.println("Date of initialization : " + "----");
        System.out.println("Number of card : " + collectionOfMusicBand.getNumberOfCardsOfCards());
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return " get information about the type of collection.";}

}
