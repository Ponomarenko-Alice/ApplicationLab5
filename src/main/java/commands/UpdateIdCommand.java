package commands;

import cmd.CommandManager;
import collection.CollectionOfMusicBand;
import collection.MusicBand;
import java.util.Arrays;

public class UpdateIdCommand extends Command {
    public UpdateIdCommand(CollectionOfMusicBand collectionOfMusicBand, CommandSet commands, String... params) {
        super(collectionOfMusicBand, commands, params);
    }

    @Override
    public void execute() {

        if (params.length == 0) {
            System.out.println("No card with this key found");
        } else {
            String param = Arrays.stream(params).toList().get(0);
            try {
                Long id = Long.parseLong(param);
                if (collectionOfMusicBand.getCollectionOfCards().get(id) != null) {
                    collectionOfMusicBand.getCollectionOfCards().remove(id);

                    CommandManager commandManager = new CommandManager();
                    MusicBand musicBand = commandManager.getNewCard(collectionOfMusicBand, params);
                    collectionOfMusicBand.addMusicBand(musicBand.getId(), musicBand);
                    System.out.println("Card update! :)");

                } else {
                    System.out.println("No card with this key found");
                }
            } catch (NumberFormatException e) {
                System.out.println("Key format must be Long");
            }
        }
    }

    @Override
    public String getName() {
        return "update_id";
    }

    @Override
    public String getDescription() {
        return " update card by its key";
    }
}
