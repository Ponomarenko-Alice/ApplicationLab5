package commands;

import collection.CollectionController;

import java.util.LinkedHashMap;

public class CommandSet {
    private final LinkedHashMap<String, Command> commands;

    public CommandSet(CollectionController collectionController) {
        this.commands = new LinkedHashMap<>();
        commands.put("help", new HelpCommand("help", " show help for available commands.", null, this));
        commands.put("info", new InfoCommand("info", " get information about the type of collection.", collectionController, this));
        commands.put("show", new ShowCommand("show", " show cards from collection.", collectionController, this));
        commands.put("save", new SaveCommand("save", " save all changes.", collectionController, this));
        commands.put("exit", new ExitCommand("exit", " exit the program", null, this));
        commands.put("clear", new ClearCommand("clear", " delete all music bands from collection.", collectionController, this));
        commands.put("insert", new InsertCommand("insert", " add new card to collection.", collectionController, this));
        commands.put("history", new HistoryCommand("history", " show last 7 commands.", null, this));
        commands.put("update_id", new UpdateIdCommand("update_id", "update card by its key", collectionController, this));
        commands.put("remove_key", new RemoveKeyCommand("remove_key", " delete a collection item by its key", collectionController, this));
        commands.put("remove_lower", new RemoveLowerKeyCommand("remove_lower", " delete a collection item by its key if one is lower parameter", collectionController, this));
        commands.put("execute_script", new ExecuteScriptCommand("execute_script", " execute commands from file.", collectionController, this));
        commands.put("remove_greater_key", new RemoveGreaterCommand("remove_greater_key", " delete a collection item by its key if one is greater parameter", collectionController, this));
        commands.put("remove_all_by_genre", new RemoveAllByGenre("remove_all_by_genre", " delete a collection item by its genre", collectionController, this));
        commands.put("count_less_than_genre", new CountLessThanGenre("count_less_than_genre", " count cards, where genre less than given ", collectionController, this));
        commands.put("group_counting_by_name", new GroupByNameCommand("group_counting_by_name", " group cards by name and shows the number in each of them ", collectionController, this));
    }

    public LinkedHashMap<String, Command> getCommandSet() {
        return commands;
    }
}