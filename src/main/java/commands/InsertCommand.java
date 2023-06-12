package commands;

import cmd.CommandUtils;
import collection.CollectionController;
import collection.MusicBand;

import java.util.ResourceBundle;


public class InsertCommand extends Command {

    public InsertCommand(String name, String description, CollectionController collectionController, CommandSet commands) {
        super(name, description, collectionController, commands);
    }

    @Override
    public void execute() {
        CommandUtils commandUtils = new CommandUtils();
        MusicBand musicBand = commandUtils.getNewCard(collectionController, params);
        collectionController.addMusicBand(musicBand.getId(), musicBand);
        String message = ResourceBundle.getBundle("notifications").getString("cardDone");
        System.out.println(message);
    }
}
