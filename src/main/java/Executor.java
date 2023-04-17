import collection.CollectionOfMusicBand;

import java.io.*;
import java.util.LinkedHashMap;

public class Executor {
    private CollectionOfMusicBand collectionOfMusicBand;

    private Executor(InputStream input, CollectionOfMusicBand collection) {


        this.collectionOfMusicBand = collection;
    }

    static {
        Invoker invoker = new Invoker();
        LinkedHashMap<String, Command> commandSet = invoker.getCommandSet();
    }

    private void start(BufferedInputStream inputStream, CollectionOfMusicBand collectionOfMusicBand) {

    }
}
