package commands;

import collection.CollectionOfMusicBand;
import collection.MusicBand;

import java.time.Instant;

public class IdGenerator {
    CollectionOfMusicBand collection;
    public IdGenerator(CollectionOfMusicBand collectionOfMusicBand) {
        this.collection = collectionOfMusicBand;
    }

    public Long getUniqueId() {
        long id = Instant.now().getEpochSecond();
        while (!this.checkUniqueId(id, collection)) {
            id = Instant.now().getEpochSecond();
        }
        return id;
    }

    private Boolean checkUniqueId(Long id, CollectionOfMusicBand collectionOfMusicBand) {
        boolean flag = true;
        for (MusicBand musicBand : collectionOfMusicBand.getCollectionOfCards().values()) {
            if (id.equals(musicBand.getId())) {
                flag = false;
                break;
            }
        }
        return flag;
    }

}
