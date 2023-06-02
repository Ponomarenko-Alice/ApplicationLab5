package commands;

import collection.CollectionOfMusicBand;
import collection.MusicBand;
import collection.MusicGenre;

import java.util.Arrays;
import java.util.Map;


public class CountLessThanGenre extends Command {
    public CountLessThanGenre(CollectionOfMusicBand collectionOfMusicBand, CommandSet commands, String... params) {
        super(collectionOfMusicBand, commands, params);
    }

    @Override
    public void execute() {
        String param = Arrays.stream(params).toList().get(0);
        boolean flag = true;
        for (MusicGenre enumName : MusicGenre.values()) {
            if (param.equals(enumName.name())) {
                flag = false;
                break;
            }
        }
//        boolean isPresent = Arrays.stream(MusicGenre.values()).anyMatch(element -> param.equals(element.name));
//        System.out.println(isPresent);
        if (params.length == 0 || flag) {
            System.out.println("Enter one of 'PSYCHEDELIC_CLOUD_RAP', 'SOUL', 'POST_PUNK'");
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
    }

    @Override
    public String getName() {
        return "count_less_than_genre";
    }

    @Override
    public String getDescription() {
        return " count cards, where genre less than given ";
    }
}
