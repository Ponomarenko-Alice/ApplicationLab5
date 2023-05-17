package commands;

import collection.CollectionOfMusicBand;
import java.util.LinkedList;

public class HistoryCommand extends Command {


    private LinkedList<String> history;

    {
        LinkedList<String> history1 = new LinkedList<>();
        this.history = history1;
    }

    public HistoryCommand(CollectionOfMusicBand collectionOfMusicBand, CommandSet commands) {
        super(collectionOfMusicBand, commands);
    }

    public void addCommandToHistory(String string) {
        history.add(0, string);
    }



    @Override
    public void execute() {
        if (history.size() <= 7) {
            for (String command : history) {
                System.out.println(command);
            }
        } else {
            for(int i = 0; i < 7; i++) {
                System.out.println(history.get(i));
            }
        }
    }

    @Override
    public String getName() {
        return "history";
    }

    @Override
    public String getDescription() {
        return " shows last 7 commands.";
    }
}
