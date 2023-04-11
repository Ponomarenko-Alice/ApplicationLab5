package collection;

import java.util.LinkedHashMap;

public class CollectionOfMusicBand {

    LinkedHashMap<Integer, Card> collectionOfCards = new LinkedHashMap<>();

    public void addCard(Integer integer, Card card) {
        collectionOfCards.put(integer, card);
    }

    public  String getName() {
        return "Music Band";
    }

    public int getNumberOfCardsOfCards() {
        return collectionOfCards.size();
    }
}
