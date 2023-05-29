package commands;

import collection.CollectionOfMusicBand;
import java.util.LinkedHashMap;

public class CommandSet {
    private final LinkedHashMap<String, Command> commands;

    public CommandSet(CollectionOfMusicBand collectionOfMusicBand) {
        this.commands = new LinkedHashMap<>();
        commands.put("help", new HelpCommand(null, this));
        commands.put("info", new InfoCommand(collectionOfMusicBand, this));
        commands.put("show", new ShowCommand(collectionOfMusicBand, this));
        commands.put("save", new SaveCommand(collectionOfMusicBand, this));
        commands.put("clear", new ClearCommand(collectionOfMusicBand, this));
        commands.put("insert", new InsertCommand(collectionOfMusicBand, this));
        commands.put("history", new HistoryCommand(null, this));
        commands.put("update_id", new UpdateIdCommand(collectionOfMusicBand, this));
        commands.put("remove_key", new RemoveKeyCommand(collectionOfMusicBand, this));
        commands.put("remove_lower", new RemoveLowerKeyCommand(collectionOfMusicBand, this));
        commands.put("remove_greater_key", new RemoveGreaterCommand(collectionOfMusicBand, this));
        commands.put("remove_all_by_genre", new RemoveAllByGenre(collectionOfMusicBand, this));
        commands.put("count_less_than_genre", new CountLessThanGenre(collectionOfMusicBand, this));
        commands.put("group_counting_by_name", new GroupByNameCommand(collectionOfMusicBand, this));

    }

    public LinkedHashMap<String, Command> getCommandSet() {
        return commands;
    }
}