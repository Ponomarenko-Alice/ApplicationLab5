package commands;

import collection.CollectionOfMusicBand;
import collection.MusicBand;
import collection.MusicGenre;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class RemoveAllByGenre extends Command {

    public RemoveAllByGenre(CollectionOfMusicBand collectionOfMusicBand, CommandSet commands, String... params) {
        super(collectionOfMusicBand, commands, params);
    }

    @Override
    public void execute() {
        if (params == null || params.length == 0) {
            System.out.println("No param. Enter one of 'PSYCHEDELIC_CLOUD_RAP', 'SOUL', 'POST_PUNK'");
        } else {
            String param = Arrays.stream(params).toList().get(0);
            boolean flag = true;
            Iterator<Map.Entry<Long, MusicBand>> iterator = collectionOfMusicBand.getCollectionOfCards().entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Long, MusicBand> entry = iterator.next();
                MusicGenre genre = entry.getValue().getGenre();
                if (genre.name().equals(param)) {
                    iterator.remove();
                    System.out.println("Card (id = " + entry.getKey() + " with genre " + genre.name() + ") removed.");
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("No card with this genre in collection");
            }
        }
    }

    @Override
    public String getName() {
        return "remove_all_by_genre";
    }

    @Override
    public String getDescription() {
        return " delete a collection item by its genre";
    }
}
