package commands;

import collection.CollectionOfMusicBand;
import collection.MusicBand;
import collection.MusicGenre;
import java.util.Map;


public class CountLessThanGenre extends Command {
    public CountLessThanGenre(String name, String description, CollectionOfMusicBand collectionOfMusicBand, CommandSet commands, String... params) {
        super(name, description, collectionOfMusicBand, commands, params);
    }

    @Override
    public void execute() {
        try {
            String param = params[0];
            boolean flag = true;
            for (MusicGenre enumName : MusicGenre.values()) {
                if (param.equals(enumName.name())) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                new EnumExistException().offerAvailableEnums();
            } else {

                int count = 0;
                for (Map.Entry<Long, MusicBand> entry : collectionOfMusicBand.getCollectionOfCards().entrySet()) {
                    MusicGenre genre = entry.getValue().getGenre();
                    if (genre.name().compareTo(param) < 0) {
                        count++;
                    }
                }
                switch (count) {
                    case 0 -> System.out.println("No cards with genre less than current");
                    case 1 -> System.out.println("1 card with genre less than current");
                    default -> System.out.println(count + " cards with genre less than current");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            new EnumExistException().offerAvailableEnums();
        }
    }
}
