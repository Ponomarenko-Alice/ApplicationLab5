import collection.Card;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\alicc\\IdeaProjects\\ApplicationLab5\\collection.csv");

            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {
                CsvToBean<Card> cb = new CsvToBeanBuilder<Card>(new BufferedReader(new InputStreamReader(bufferedInputStream)))
                        .withType(Card.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                //HashMap<String, Card> hashMap = new LinkedHashMap<String, Card>();
                List<Card> list = cb.parse();
                for (Card card : list) {
                    System.out.println("ID: " + card.getId());
                    System.out.println("name: " + card.getName());
                    System.out.println("surname: " + card.getSurname());

                }

//                for (Card card: cb.stream().toList()) {
//                    System.out.println(card);
//                }

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