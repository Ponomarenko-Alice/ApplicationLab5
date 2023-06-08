package commands;

import collection.CollectionController;

import java.util.Arrays;

public class RemoveKeyCommand extends Command {

    public RemoveKeyCommand(String name, String description, CollectionController collectionController, CommandSet commands, String... params) {
        super(name, description, collectionController, commands, params);
    }

    @Override
    public void execute() {

        if (params.length == 0) {
            System.out.println("No card with this key found");
        } else {
            String param = Arrays.stream(params).toList().get(0);
            try {
                Long id = Long.parseLong(param);
                if (collectionController.getCollectionOfCards().get(id) != null) {
                    collectionController.getCollectionOfCards().remove(id);
                    System.out.println("Card (id = " + id + ") removed.");
                } else {
                    System.out.println("No card with this key found");
                }
            } catch (NumberFormatException e) {
                System.out.println("Key format must be Long");
            }
        }
    }
}
