
import collection.MusicBand;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\alicc\\IdeaProjects\\ApplicationLab5\\collection.csv");

            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {
                CsvToBean<MusicBand> cb = new CsvToBeanBuilder<MusicBand>(new BufferedReader(new InputStreamReader(bufferedInputStream)))
                        .withType(MusicBand.class)
                        .withSeparator(';')
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                //HashMap<String, Card> hashMap = new LinkedHashMap<String, Card>();
                List<MusicBand> list = cb.parse();
                for (MusicBand musicBand : list) {

                    System.out.println("ID: " + musicBand.getId());
                    System.out.println("name: " + musicBand.getName());
                    System.out.println("coordinates " + musicBand.getCoordinates());

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