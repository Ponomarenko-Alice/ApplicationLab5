package cmd;

import collection.CollectionController;
import collection.MusicBand;

import java.time.Instant;

public class IdGenerator {
    CollectionController collection;

    public IdGenerator(CollectionController collectionController) {
        this.collection = collectionController;
    }

    public Long getUniqueId() {
        long id = Instant.now().getEpochSecond();
        while (!this.checkUniqueId(id, collection)) {
            id = Instant.now().getEpochSecond();
        }
        return id;
    }

    private Boolean checkUniqueId(Long id, CollectionController collectionController) {
        boolean flag = true;
        for (MusicBand musicBand : collectionController.getCollectionOfCards().values()) {
            if (id.equals(musicBand.getId())) {
                flag = false;
                break;
            }
        }
        return flag;
    }

}
