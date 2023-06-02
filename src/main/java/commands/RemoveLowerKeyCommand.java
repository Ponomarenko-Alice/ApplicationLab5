package commands;

import collection.CollectionOfMusicBand;

import java.util.Arrays;


public class RemoveLowerKeyCommand extends Command {

    public RemoveLowerKeyCommand(CollectionOfMusicBand collectionOfMusicBand, CommandSet commands, String... params) {
        super(collectionOfMusicBand, commands, params);
    }

    @Override
    public void execute() {
        if (params.length == 0) {
            System.out.println("No param");
        } else {
            String param = Arrays.stream(params).toList().get(0);
            try {
                Integer number = Integer.parseInt(param);
                Long[] keys = collectionOfMusicBand.getCollectionOfCards().keySet().stream().toList().toArray(new Long[0]);
                for (Long key : keys) {
                    if (key < number) {
                        collectionOfMusicBand.getCollectionOfCards().remove(key);
                        System.out.println("Card (id = " + key + ") removed.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Param format must be int");
            }
        }
    }

    @Override
    public String getName() {
        return "remove_lower";
    }

    @Override
    public String getDescription() {
        return " delete a collection item by its key if one is lower parameter";
    }
}

