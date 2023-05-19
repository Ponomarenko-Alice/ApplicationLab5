package commands;

import collection.CollectionOfMusicBand;
import collection.MusicBand;
import org.jetbrains.annotations.NotNull;

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
        Scanner in = null;
        try {
            in = new Scanner(System.in);
            if (params.length == 0) {
                System.out.println("Id will be generated");
//                генерируем айдишник сами и передаем в конструктор
            } else {
                String param = Arrays.stream(params).toList().get(0);
                if (this.checkFormatId(param) && this.checkUniqueId(param)) {
                    System.out.println("good id");
//                     передаем айдишник в конструктор карточки
                } else {
                    if (!this.checkFormatId(param)) {
                        System.out.println("Enter id in format 1-18 digits only. Try again or enter null");
                    }
                    if (!this.checkUniqueId(param)) {
                        System.out.println("This id already exists. Try again");
                    }
                    this.whileBlock(in);

                }
            }
        } catch (NumberFormatException e) {
            assert in != null;
            this.whileBlock(in);
        }
    }

    private Boolean checkUniqueId(String str) throws NumberFormatException{
        boolean flag = true;
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
        boolean flag = true;
        String regex = "^[0-9]{1,18}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher mather = pattern.matcher(str);
        if (!mather.matches()) {
            flag = false;
        }
        return flag;
    }

    private Boolean checkNotNullId(String str) {
        return str.length() != 0;
    }

    private void whileBlock(@NotNull Scanner in) {
        while (true) {
            String id = in.nextLine();
            if (this.checkNotNullId(id) && this.checkFormatId(id) && this.checkUniqueId(id)) {
                System.out.println("success!");
                // айдишник корректен, выходим из цикла
                break;
            } else {
                if (!this.checkNotNullId(id)) {
                    System.out.println("Id will be generated");
                    // генерируем айдишник сами и передаем в конструктор
                    break;
                } else if (!this.checkFormatId(id)) {
                    System.out.println("Enter id in format 1-18 digits only. Try again or enter null");
                } else if (!this.checkUniqueId(id)) {
                    System.out.println("This id already exists. Try again");
                } else {
                    System.out.println("Bad id. Try again");
                }
            }
        }
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
