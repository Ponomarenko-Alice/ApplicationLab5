package commands;

import collection.CollectionOfMusicBand;
import collection.MusicBand;
import data.WriterCSV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class SaveCommand extends Command{
    private List<String[]> stringFieldsList;

    public SaveCommand(String name, String description, CollectionOfMusicBand collectionOfMusicBand) {
        super(name, description, collectionOfMusicBand);
    }


    {
        List<String[]> stringListCollection = new ArrayList<>();
        try {
            for (MusicBand card : collectionOfMusicBand.getCollectionOfCards().values()) {
                String[] stringCardList = new String[11];

                stringCardList[0] = card.getId().toString();
                stringCardList[1] = card.getName();
//                stringCardList[2] = card.getCoordinates().getX().toString();
//                stringCardList[3] = card.getCoordinates().getY().toString();
                stringCardList[4] = card.getCreationDate().toString();
//                stringCardList[5] = card.getNumberOfParticipants().toString();
//                Integer a = new Integer(card.getSinglesCount());
//                stringCardList[6] = a.toString();
//                stringCardList[7] = card.getAlbumsCount().toString();
//                stringCardList[8] = card.getGenre().toString();
////                stringCardList[9] = card.getLabel().getName();
////                Integer b = new Integer(card.getLabel().getBands()); <----------
////                stringCardList[10] = b.toString();

//TODO показать блок инициализации

                stringListCollection.add(stringCardList);

            }
            this.stringFieldsList = stringListCollection;
        } catch (Exception ignored) {
        }

    }

    @Override
    public void execute() throws IOException {
        WriterCSV writerCSV = new WriterCSV("out.csv", stringFieldsList);
        writerCSV.writeToFile();
        System.out.println("The collection was saved successfully to file " + writerCSV.getFileName());


    }


}