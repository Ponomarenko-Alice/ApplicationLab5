import collection.MusicBand;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.util.List;

public class ParserCSV {
    private final File file;

    public ParserCSV(File file) {
        this.file = file;
    }

    public List<MusicBand> getListCollection() {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {


            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {

                ColumnPositionMappingStrategy<MusicBand> musicBandStrategy = new ColumnPositionMappingStrategy<>();
                musicBandStrategy.setType(MusicBand.class);
                musicBandStrategy.setColumnMapping("id", "name", "coordinates.x", "coordinates.y", "creationDate", "numberOfParticipants",
                        "singlesCount", "albumsCount", "genre", "label.name", "label.bands");

                CsvToBean<MusicBand> cb = new CsvToBeanBuilder<MusicBand>(new BufferedReader(new InputStreamReader(bufferedInputStream)))
                        .withMappingStrategy(musicBandStrategy)
                        .withType(MusicBand.class)
                        .withSeparator(',')
                        .withSkipLines(1)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                return cb.parse();


        } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
