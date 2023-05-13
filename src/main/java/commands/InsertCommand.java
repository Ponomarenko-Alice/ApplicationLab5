package commands;

import collection.CollectionOfMusicBand;

public class InsertCommand extends Command {

    public InsertCommand(CollectionOfMusicBand collectionOfMusicBand) {
        super(collectionOfMusicBand);
    }

    @Override
    public void execute() {
        try {
            System.out.println("");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public String getDescription() {
        return " adds new card to collection.";
    }
}
