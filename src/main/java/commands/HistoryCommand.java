package commands;

import collection.CollectionOfMusicBand;

import java.util.LinkedList;

public class HistoryCommand extends Command {


    private final LinkedList<String> history;

    {
        this.history = new LinkedList<>();
    }

    public HistoryCommand(String name, String description, CollectionOfMusicBand collectionOfMusicBand, CommandSet commands) {
        super(name, description, collectionOfMusicBand, commands);
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
