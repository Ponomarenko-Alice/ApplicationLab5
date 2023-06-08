package commands;

import collection.CollectionController;

import java.util.Arrays;

public class RemoveGreaterCommand extends Command {
    public RemoveGreaterCommand(String name, String description, CollectionController collectionController, CommandSet commands, String... params) {
        super(name, description, collectionController, commands, params);
    }

    @Override
    public void execute() {
        if (params.length == 0) {
            System.out.println("No param");
        } else {
            String param = Arrays.stream(params).toList().get(0);
            try {
                Integer number = Integer.parseInt(param);
                Long[] keys = collectionController.getCollectionOfCards().keySet().stream().toList().toArray(new Long[0]);
                for (Long key : keys) {
                    if (key > number) {
                        collectionController.getCollectionOfCards().remove(key);
                        System.out.println("Card (id = " + key + ") removed.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Param format must be int");
            }
        }
    }
}
