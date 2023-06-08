package commands;

import collection.CollectionController;

public class ClearCommand extends Command {

    public ClearCommand(String name, String description, CollectionController collectionController, CommandSet commandSet, String... params) {
        super(name, description, collectionController, commandSet, params);
    }

    @Override
    public void execute() {
        if (collectionController.getNumberOfCardsOfCards() == 0) {
            System.out.println("Collection is already empty");
        } else {
            collectionController.getCollectionOfCards().clear();
            System.out.println("Collection is empty now");
        }
    }
}
















