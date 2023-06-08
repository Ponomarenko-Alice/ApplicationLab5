package commands;

import collection.CollectionController;


public class InfoCommand extends Command {

    public InfoCommand(String name, String description, CollectionController collectionController, CommandSet commands) {
        super(name, description, collectionController, commands);
    }

    @Override
    public void execute() {
        System.out.println("-INFORMATION ABOUT COLLECTION-");
        System.out.println("Type of collection: " + collectionController.getName());
        System.out.println("Date of initialization : " + "----");
        System.out.println("Number of card : " + collectionController.getNumberOfCardsOfCards());
    }
}
