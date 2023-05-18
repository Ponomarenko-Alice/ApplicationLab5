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


    public void start() {
        this.fillCollectionMusicBand();

        Scanner scanner = new Scanner(input);
        CommandSet commandSet = new CommandSet(this.collectionOfMusicBand);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            try {
                if (line != null) {
                    String[] tokens = line.trim().split(" ");

                    Command command = commandSet.getCommandSet().get(tokens[0]);
                    String[] tokens1 = remove(tokens, 0);
                    if (tokens1.length != 0) {
                        command.setParams(tokens1);
                    }
                    command.execute();

                    HistoryCommand historyCommand1 = (HistoryCommand) commandSet.getCommandSet().get("history");
                    historyCommand1.addCommandToHistory(tokens[0]);


                } else {
                    System.out.println("line is null");
                }
            } catch (NullPointerException e) {
                System.out.println("Non-existed command. Try 'help' command for available commands.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
