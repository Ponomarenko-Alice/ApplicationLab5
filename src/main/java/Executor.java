import collection.CollectionOfMusicBand;
import collection.MusicBand;
import commands.Command;
import commands.CommandSet;
import commands.HistoryCommand;

import java.io.*;
import java.util.Scanner;

import static org.apache.commons.lang3.ArrayUtils.remove;

public class Executor {
    private final InputStream input;
    private final File file;
    private CollectionOfMusicBand collectionOfMusicBand;
    CommandSet commandSet;


    public Executor(InputStream inputStream, CollectionOfMusicBand collectionOfMusicBand, File file) {
        this.input = inputStream;
        this.collectionOfMusicBand = collectionOfMusicBand;
        this.file = file;
    }

    private void fillCollectionMusicBand() {
        ParserCSV parser = new ParserCSV(file);
        for (MusicBand musicBand : parser.getListCollection()) {
            collectionOfMusicBand.addMusicBand(musicBand.getId(), musicBand);
        }
    }

    public void executeLine(String line) {
        try {
            String[] tokens = line.trim().split("\\s+");
            Command command = commandSet.getCommandSet().get(tokens[0]);
            String[] params = remove(tokens, 0);
            if (params.length != 0) {
                command.setParams(params);
            }
            command.execute();

            HistoryCommand historyCommand1 = (HistoryCommand) commandSet.getCommandSet().get("history");
            historyCommand1.addCommandToHistory(tokens[0]);

        } catch (NullPointerException e) {
            System.out.println("Non-existed command. Try 'help' command for available commands.");
        }
    }

    public void start() {
        this.fillCollectionMusicBand();
        this.commandSet = new CommandSet(this.collectionOfMusicBand);

        Scanner scanner = new Scanner(input);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            this.executeLine(line);
        }
    }
}
