package commands;

import collection.CollectionOfMusicBand;
import collection.MusicBand;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InsertCommand extends Command {

    public InsertCommand(CollectionOfMusicBand collectionOfMusicBand, CommandSet commands) {
        super(collectionOfMusicBand, commands);
    }

    @Override
    public void execute() {
        try {

            Scanner in = new Scanner(System.in);
            if (params.length != 0) {
                if (this.checkFormatId(Arrays.stream(params).toList().get(0))) {
                    if (this.checkUniqueId(Arrays.stream(params).toList().get(0))) {
                        System.out.println("good for first time");
//                        передаем айдишник в конструктор картотчки
                    } else {
                        System.out.println("not unique");
                    }
                } else {
                    System.out.println("Enter id in format 1-18 digits only");
                }
            } else {
//                генерируем айдишник сами и передаем в конструктор
                System.out.println("null line. try again");
                while (!this.checkUniqueId(in.nextLine())) {
                    System.out.println("This id is already exist. Try again");
                }
                System.out.println("success!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Boolean checkUniqueId(String str) {
        boolean flag = true;
//        блок try который выкидывает ошибку если не может перевести в long(под вопросом, должно провериться в формате сначла)
        Long id = Long.parseLong(str);
        for (MusicBand musicBand : collectionOfMusicBand.getCollectionOfCards().values()) {
            if (id.equals(musicBand.getId())) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private Boolean checkFormatId(String str) {

        boolean flag = false;
        String regex = "^[0-9]{1,18}$";
        Pattern pattern = Pattern.compile(regex);

        Matcher mather = pattern.matcher(str);
        if (mather.matches()) {
            flag = true;
            System.out.println("Enter id in format 1-18 digits only");
        }
        return flag;
    }

    private Boolean checkNotNullId(String str) {
        boolean flag = true;
        if (str.length() == 0) {
            flag = false;
            System.out.println("null line");
        }
        return flag;
    }



    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public String getDescription() {
        return " adds new card to collection.";
    }
}





