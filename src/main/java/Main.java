
import collection.MusicBand;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\alicc\\IdeaProjects\\ApplicationLab5\\collection.csv");

            ColumnPositionMappingStrategy<MusicBand> musicBandStrategy = new ColumnPositionMappingStrategy<>();
            musicBandStrategy.setType(MusicBand.class);
            musicBandStrategy.setColumnMapping("id", "name", "coordinates.x","coordinates.y","creationDate", "numberOfParticipants",
                    "singlesCount", "albumsCount", "genre", "label.name", "label.bands");


            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {
                CsvToBean<MusicBand> cb = new CsvToBeanBuilder<MusicBand>(new BufferedReader(new InputStreamReader(bufferedInputStream)))
                        .withMappingStrategy(musicBandStrategy)
                        .withType(MusicBand.class)
                        .withSeparator(';')
                        .withSkipLines(1)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                List<MusicBand> list = cb.parse();
                for (MusicBand musicBand : list) {

                    System.out.println("ID: " + musicBand.getId());
                    System.out.println("name: " + musicBand.getName());
//                    System.out.println("coordinates " + musicBand.getCoordinates().getX() + musicBand.getCoordinates().getY());
                    System.out.println("LocalDate " + musicBand.getCreationDate());
                    System.out.println("number of participant " + musicBand.getNumberOfParticipants());


                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            fileInputStream.close();
        } catch (FileNotFoundException ignored) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
