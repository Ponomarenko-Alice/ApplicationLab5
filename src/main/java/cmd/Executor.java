package cmd;

import collection.CollectionController;
import collection.MusicBand;
import commands.CommandSet;
import commands.ExitException;

import java.io.*;
import java.util.Scanner;

public class Executor {
    private final InputStream input;
    private final File file;
    private final CollectionController collectionController;


    public Executor(InputStream inputStream, CollectionController collectionController, File file) {
        this.input = inputStream;
        this.collectionController = collectionController;
        this.file = file;
    }

    private void fillCollectionMusicBand() {
        ParserCSV parser = new ParserCSV(file);
        for (MusicBand musicBand : parser.getListCollection()) {
            collectionController.addMusicBand(musicBand.getId(), musicBand);
        }
    }


    public void start() {
        this.fillCollectionMusicBand();
        CommandSet commandSet = new CommandSet(this.collectionController);
        Scanner scanner = new Scanner(input);
        LineExecutor lineExecutor = new LineExecutor();
        while (scanner.hasNextLine()) {
            try {
                String line = scanner.nextLine();
                lineExecutor.executeLine(line, commandSet);
            } catch (ExitException e) {
                break;
            }
        }
    }
}
