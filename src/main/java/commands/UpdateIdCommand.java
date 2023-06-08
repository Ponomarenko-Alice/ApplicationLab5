package commands;

import cmd.UtilityMethods;
import collection.CollectionController;
import collection.MusicBand;

import java.util.Arrays;

public class UpdateIdCommand extends Command {
    public UpdateIdCommand(String name, String description, CollectionController collectionController, CommandSet commands, String... params) {
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
                    UtilityMethods utilityMethods = new UtilityMethods();
                    MusicBand musicBand = utilityMethods.getNewCard(collectionController, params);
                    collectionController.addMusicBand(musicBand.getId(), musicBand);
                    System.out.println("Card update! :)");
                } else {
                    System.out.println("No card with this key found");
                }
            } catch (NumberFormatException e) {
                System.out.println("Key format must be Long");
            }
        }
    }
}
