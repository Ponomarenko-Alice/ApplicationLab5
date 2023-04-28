import collection.CollectionOfMusicBand;
import collection.MusicBand;
import commands.Command;
import commands.CommandSet;

import java.io.*;
import java.util.LinkedHashMap;


public class Executor {
    private CollectionOfMusicBand collectionOfMusicBand;
    private InputStream input;

    Executor() {
    }


    static {
        CommandSet cs = new CommandSet();
        LinkedHashMap<String, Command> commandSet = cs.getCommandSet();
    }

//    метод принимает файл из main, должен заполнить коллекцию

    private void fillCollectionMusicBand(File file1, CollectionOfMusicBand collectionOfMusicBand1) {
        ParserCSV parser = new ParserCSV(file1);
        for (MusicBand musicBand : parser.getListCollection()) {
            collectionOfMusicBand1.addMusicBand(musicBand.getId(), musicBand);
        }
    }

//    Коллекцию создали в main один раз
    public void start(InputStream inputStream, CollectionOfMusicBand collectionOfMusicBand, File file) {
        this.collectionOfMusicBand = collectionOfMusicBand;
        this.fillCollectionMusicBand(file, collectionOfMusicBand);
        System.out.println(collectionOfMusicBand.getCollectionOfCards());

    }


}
