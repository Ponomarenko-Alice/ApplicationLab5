package commands;

import collection.CollectionController;

import java.util.LinkedList;

public class HistoryCommand extends Command {


    private final LinkedList<String> history;

    {
        this.history = new LinkedList<>();
    }

    public HistoryCommand(String name, String description, CollectionController collectionController, CommandSet commands) {
        super(name, description, collectionController, commands);
    }

    public void addCommandToHistory(String string) {
        history.add(0, string);
    }

    @Override
    public void execute() {
        int countOfCommands = 7;
        if (history.size() <= countOfCommands) {
            for (String command : history) {
                System.out.println(command);
            }
        } else {
            for (int i = 0; i < countOfCommands; i++) {
                System.out.println(history.get(i));
            }
        }
    }
}
