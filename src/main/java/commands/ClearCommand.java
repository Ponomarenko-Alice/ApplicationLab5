package commands;

import collection.CollectionController;

import java.util.ResourceBundle;

public class ClearCommand extends Command {

    public ClearCommand(String name, String description, CollectionController collectionController, CommandSet commandSet, String... params) {
        super(name, description, collectionController, commandSet, params);
    }

    @Override
    public void execute() {
        if (collectionController.getNumberOfCardsOfCards() == 0) {
            String message = ResourceBundle.getBundle("notifications").getString("alreadyEmptyCollection");
            System.out.println(message);
        } else {
            collectionController.getCollectionOfCards().clear();
            String message = ResourceBundle.getBundle("notifications").getString("emptyNow");
            System.out.println(message);
        }
    }
}
















