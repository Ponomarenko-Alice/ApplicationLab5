package cmd;

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
    private final CollectionOfMusicBand collectionOfMusicBand;
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

    public CommandSet getCommandSet() {
        return commandSet;
    }

    public void executeLine(String line, CommandSet commandSet) {
        try {

            String[] tokens = line.trim().split("\\s+");
            Command command = commandSet.getCommandSet().get(tokens[0]);
            String[] params = remove(tokens, 0);
            if (params.length != 0) {
                command.setParams(params);
            }
            command.execute();

            HistoryCommand historyCommand = commandSet.getCommandSet().values().stream()
                    .filter(x -> x instanceof HistoryCommand)
                    .map(x -> (HistoryCommand) x)
                    .findFirst()
                    .orElse(null);
            assert historyCommand != null;
            historyCommand.addCommandToHistory(tokens[0]);

        } catch (NullPointerException e) {
            System.out.println("Non-existed command. Try 'help' command for available commands.");
        }
    }

    public void start() {
        this.fillCollectionMusicBand();
        this.commandSet = new CommandSet(this.collectionOfMusicBand);

        Scanner scanner = new Scanner(input);
        this.commandSet = new CommandSet(this.collectionOfMusicBand);


        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            this.executeLine(line, commandSet);
        }
    }
}
