import collection.CollectionOfMusicBand;
import collection.MusicBand;
import commands.Command;
import commands.CommandSet;
import java.io.*;
import java.util.Scanner;

public class Executor {
    private final InputStream input;
    private final File file;
    private CollectionOfMusicBand collectionOfMusicBand;

    public Executor(InputStream inputStream, CollectionOfMusicBand collectionOfMusicBand, File file) {
        this.input = inputStream;
        this.collectionOfMusicBand = collectionOfMusicBand;
        this.file = file;
    }

    CommandSet commandSet = new CommandSet(collectionOfMusicBand);

    private void fillCollectionMusicBand() {
        ParserCSV parser = new ParserCSV(file);
        for (MusicBand musicBand : parser.getListCollection()) {
            collectionOfMusicBand.addMusicBand(musicBand.getId(), musicBand);
        }
    }

    public void start() {
        this.fillCollectionMusicBand();

        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line != null) {
                String[] tokens = line.split(" ");
                Command command = commandSet.getCommandSet().get(tokens[0]);
                command.execute();
            }
        }
    }

}
