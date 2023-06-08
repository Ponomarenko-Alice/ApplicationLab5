package commands;

import cmd.UtilityMethods;
import collection.CollectionController;
import collection.MusicBand;


public class InsertCommand extends Command {

    public InsertCommand(String name, String description, CollectionController collectionController, CommandSet commands) {
        super(name, description, collectionController, commands);
    }

    @Override
    public void execute() {
        UtilityMethods utilityMethods = new UtilityMethods();
        MusicBand musicBand = utilityMethods.getNewCard(collectionController, params);
        collectionController.addMusicBand(musicBand.getId(), musicBand);
        System.out.println("Card done! Don't forget to save collection :)");
    }
}
