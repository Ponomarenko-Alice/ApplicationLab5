package cmd;

import collection.CollectionController;
import collection.MusicBand;
import commands.CommandSet;
import commands.ExitException;
import commands.RecursionScriptException;

import java.io.*;
import java.util.Scanner;

public class Executor {
    private static Executor INSTANCE = null;
    private final InputStream input;
    private final File file;
    private final CollectionController collectionController;
    private int recursionLevel = 0;


    private Executor(InputStream inputStream, CollectionController collectionController, File file) {
        this.input = inputStream;
        this.collectionController = collectionController;
        this.file = file;
    }

    public static Executor getInstance() {
        if (INSTANCE == null) {
            throw new AssertionError("You have to call init first");
        }
        return INSTANCE;
    }

    public static Executor init(InputStream inputStream, CollectionController collectionController, File file) {
        if (INSTANCE != null) {
            throw new AssertionError("You already initialized Executor");
        }
        INSTANCE = new Executor(inputStream, collectionController, file);
        return INSTANCE;
    }

    private void fillCollectionMusicBand() {
        ParserCSV parser = new ParserCSV(file);
        for (MusicBand musicBand : parser.getListCollection()) {
            collectionController.addMusicBand(musicBand.getId(), musicBand);
        }
    }

    public int getRecursionLevel() {return recursionLevel;}
    public void increaseRecursionLevel() {recursionLevel++;}


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
            } catch (RecursionScriptException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
