package commands;

import collection.CollectionController;
import collection.MusicBand;

import java.util.*;

public class GroupByNameCommand extends Command {
    public GroupByNameCommand(String name, String description, CollectionController collectionController, CommandSet commands, String... params) {
        super(name, description, collectionController, commands, params);
    }

    @Override
    public void execute() {

        Map<String, Integer> names = new HashMap<>();

        for (Map.Entry<Long, MusicBand> entry : collectionController.getCollectionOfCards().entrySet()) {
            String currentCardName = entry.getValue().getName();
            if (names.containsKey(currentCardName)) {
                int currentCount = names.get(currentCardName);
                names.replace(currentCardName, currentCount + 1); //add count of cards with one name
            } else {
                names.put(currentCardName, 1);
            }
        }
        for (Map.Entry<String, Integer> set : names.entrySet()) {
            System.out.println(set.getKey() + ": " + set.getValue());
        }

    }
}
