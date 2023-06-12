package commands;

import cmd.CommandUtils;
import collection.CollectionController;
import collection.MusicBand;
import java.util.Arrays;
import java.util.ResourceBundle;

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
                    CommandUtils commandUtils = new CommandUtils();
                    MusicBand musicBand = commandUtils.getNewCard(collectionController, params);
                    collectionController.addMusicBand(musicBand.getId(), musicBand);
                    System.out.println("Card update! :)");
                } else {
                    String message = ResourceBundle.getBundle("warnings").getString("noCardWithKey");
                    System.out.println(message);
                }
            } catch (NumberFormatException e) {
                String message = ResourceBundle.getBundle("warnings").getString("longFormat");
                System.out.println(message);
            }
        }
    }
}
