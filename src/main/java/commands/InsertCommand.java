package commands;

import collection.CollectionOfMusicBand;



public class InsertCommand extends Command {

    public InsertCommand(CollectionOfMusicBand collectionOfMusicBand, CommandSet commands) {
        super(collectionOfMusicBand, commands);
    }

    @Override
    public void execute() {
        CommandManager commandManager = new CommandManager();
        commandManager.getIdFromUser(collectionOfMusicBand, params);
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
