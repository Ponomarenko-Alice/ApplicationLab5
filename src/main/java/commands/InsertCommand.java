package commands;

import cmd.CommandManager;
import collection.CollectionOfMusicBand;
import collection.MusicBand;


public class InsertCommand extends Command {

    public InsertCommand(CollectionOfMusicBand collectionOfMusicBand, CommandSet commands) {
        super(collectionOfMusicBand, commands);
    }

    @Override
    public void execute() {
        CommandManager commandManager = new CommandManager();
        MusicBand musicBand = commandManager.getNewCard(collectionOfMusicBand, params);
        collectionOfMusicBand.addMusicBand(musicBand.getId(), musicBand);
        System.out.println("Card done! Don't forget to save collection :)");
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
