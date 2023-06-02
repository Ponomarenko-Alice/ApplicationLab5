package commands;

import collection.CollectionOfMusicBand;
import collection.MusicBand;


public class ShowCommand extends Command {

    public ShowCommand(CollectionOfMusicBand collectionOfMusicBand, CommandSet commands) {
        super(collectionOfMusicBand, commands);
    }

    @Override
    public void execute() {
        if (collectionOfMusicBand.getNumberOfCardsOfCards() > 0) {
            for (MusicBand value : collectionOfMusicBand.getCollectionOfCards().values()) {
                System.out.println("ID: " + value.getId());
                System.out.println("Name: " + value.getName());
//            System.out.println("coordinates.X: " + value.getCoordinates().getX());
//            System.out.println("coordinates.Y: " + value.getCoordinates().getY());
                System.out.println("CreationDate: " + value.getCreationDate());
                System.out.println("NumberOfParticipants: " + value.getNumberOfParticipants());
                System.out.println("SinglesCount: " + value.getSinglesCount());
                System.out.println("AlbumsCount: " + value.getAlbumsCount());
                System.out.println("Genre: " + value.getGenre());
//            System.out.println("label.name: " + value.getLabel().getName());
//            System.out.println("label.bands: " + value.getLabel().getBands());

                System.out.println(" ");
            }
        } else {
            System.out.println("Collection is empty");
        }

    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return " show cards from collection.";
    }
}
