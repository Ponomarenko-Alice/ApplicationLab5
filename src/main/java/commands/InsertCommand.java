package commands;

import cmd.CommandManager;
import collection.CollectionOfMusicBand;
import collection.MusicBand;


public class InsertCommand extends Command {

    public InsertCommand(String name, String description,CollectionOfMusicBand collectionOfMusicBand, CommandSet commands) {
        super(name, description, collectionOfMusicBand, commands);
    }

    @Override
    public void execute() {
        CommandManager commandManager = new CommandManager();
        MusicBand musicBand = commandManager.getNewCard(collectionOfMusicBand, params);
        collectionOfMusicBand.addMusicBand(musicBand.getId(), musicBand);
        System.out.println("Card done! Don't forget to save collection :)");
    }
}
