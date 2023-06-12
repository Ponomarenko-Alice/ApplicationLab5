package commands;

import collection.CollectionController;
import collection.MusicBand;
import collection.MusicGenre;
import exceptions.EnumExistException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

public class RemoveAllByGenre extends Command {

    public RemoveAllByGenre(String name, String description, CollectionController collectionController, CommandSet commands, String... params) {
        super(name, description, collectionController, commands, params);
    }

    @Override
    public void execute() {
        if (params == null || params.length == 0) {
            System.out.println("No param. ");
            new EnumExistException().offerAvailableEnums();
        } else {
            String param = Arrays.stream(params).toList().get(0);
            boolean flag = true;
            Iterator<Map.Entry<Long, MusicBand>> iterator = collectionController.getCollectionOfCards().entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Long, MusicBand> entry = iterator.next();
                MusicGenre genre = entry.getValue().getGenre();
                if (genre.name().equals(param)) {
                    iterator.remove();
                    System.out.println("Card (id = " + entry.getKey() + " with genre " + genre.name() + ") removed.");
                    flag = false;
                }
            }
            if (flag) {
                String message = ResourceBundle.getBundle("warnings").getString("noCardWithGenre");
                System.out.println(message);
            }
        }
    }
}
