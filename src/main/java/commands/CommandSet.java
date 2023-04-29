package commands;
import collection.CollectionOfMusicBand;

import java.util.LinkedHashMap;

public class CommandSet {
    private CollectionOfMusicBand collectionOfMusicBand;

    public CommandSet(CollectionOfMusicBand collectionOfMusicBand) {
        this.collectionOfMusicBand = collectionOfMusicBand;
    }

    public LinkedHashMap<String, Command> getCommandSet() {
        LinkedHashMap<String, Command> commands = new LinkedHashMap<>();
        commands.put("help", new HelpCommand("help"," shows help for available commands.", collectionOfMusicBand));
        commands.put("info", new InfoCommand("info", " gets information about the type of collection.", collectionOfMusicBand));
        commands.put("show", new ShowCommand("show", " description", collectionOfMusicBand));
        commands.put("clear", new ClearCommand("clear", " delete all music bands from collection", collectionOfMusicBand));


        return commands;
    }

}