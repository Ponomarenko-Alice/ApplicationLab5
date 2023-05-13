package commands;

import collection.CollectionOfMusicBand;

import java.util.LinkedHashMap;

public class CommandSet {
    private CollectionOfMusicBand collectionOfMusicBand;
    private LinkedHashMap<String, Command> commands;

    public CommandSet(CollectionOfMusicBand collectionOfMusicBand) {
        this.collectionOfMusicBand = collectionOfMusicBand;
        this.commands = new LinkedHashMap<>();
        commands.put("help", new HelpCommand(null));
        commands.put("info", new InfoCommand(collectionOfMusicBand));
        commands.put("show", new ShowCommand(collectionOfMusicBand));
        commands.put("clear", new ClearCommand(collectionOfMusicBand));
        commands.put("save", new SaveCommand(collectionOfMusicBand));
        commands.put("history", new HistoryCommand(null));
    }


    public LinkedHashMap<String, Command> getCommandSet() {
        return commands;
    }
}