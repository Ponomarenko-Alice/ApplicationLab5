import collection.CollectionOfMusicBand;
import collection.MusicBand;
import commands.ShowCommand;

import java.io.*;

public class Executor {
    private InputStream input;
    private File file;
    private CollectionOfMusicBand collectionOfMusicBand;

    public Executor(InputStream inputStream, CollectionOfMusicBand collectionOfMusicBand, File file) {
        this.input = inputStream;
        this.collectionOfMusicBand = collectionOfMusicBand;
        this.file = file;
    }

//    static {
//        CommandSet cs = new CommandSet();
//        LinkedHashMap<String, Command> commandSet = cs.getCommandSet();
//    }

//    метод принимает файл из main, должен заполнить коллекцию

    private void fillCollectionMusicBand() {
        ParserCSV parser = new ParserCSV(file);
        for (MusicBand musicBand : parser.getListCollection()) {
            collectionOfMusicBand.addMusicBand(musicBand.getId(), musicBand);
        }
    }

//    Коллекцию создали в main один раз
    public void start() {
        this.fillCollectionMusicBand();
        ShowCommand sc = new ShowCommand("", "", collectionOfMusicBand);
        sc.execute();
    }

}
