package collection;

import java.util.LinkedHashMap;

public class CollectionOfMusicBand {
    LinkedHashMap<Integer, Card> collectionOfCards = new LinkedHashMap<>();

    public void addCard(Integer integer, Card card) {
        collectionOfCards.put(integer, card);
    }
}
