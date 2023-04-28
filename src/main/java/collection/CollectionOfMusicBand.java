package collection;

import java.util.LinkedHashMap;

public class CollectionOfMusicBand {

    LinkedHashMap<Long, MusicBand> collectionOfCards = new LinkedHashMap<>();

    public LinkedHashMap<Long, MusicBand> getCollectionOfCards() {
        return collectionOfCards;
    }

    public void addMusicBand(Long key, MusicBand musicBand) {
        collectionOfCards.put(key, musicBand);
    }

    public  String getName() {
        return "Music Band";
    }

    public int getNumberOfCardsOfCards() {
        return collectionOfCards.size();
    }
}
