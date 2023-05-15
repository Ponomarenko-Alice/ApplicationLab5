package commands;

import collection.CollectionOfMusicBand;

import java.util.LinkedHashMap;

public class CommandSet {
    private CollectionOfMusicBand collectionOfMusicBand;
    private final LinkedHashMap<String, Command> commands;

    public CommandSet(CollectionOfMusicBand collectionOfMusicBand) {
        this.collectionOfMusicBand = collectionOfMusicBand;
        this.commands = new LinkedHashMap<>();
        commands.put("help", new HelpCommand(null, this));
        commands.put("info", new InfoCommand(collectionOfMusicBand, this));
        commands.put("show", new ShowCommand(collectionOfMusicBand, this));
        commands.put("clear", new ClearCommand(collectionOfMusicBand, this));
        commands.put("save", new SaveCommand(collectionOfMusicBand, this));
        commands.put("history", new HistoryCommand(null, this));
    }


    public LinkedHashMap<String, Command> getCommandSet() {
        return commands;
    }
}