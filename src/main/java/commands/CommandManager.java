package commands;

import collection.CollectionOfMusicBand;
import collection.MusicBand;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandManager {
    
    public CommandManager() {}
    
    public Long getIdFromUser(CollectionOfMusicBand collectionOfMusicBand, String[] params) {
        Scanner in = new Scanner(System.in);
        if (params.length == 0) {
            System.out.println("Id will be generated");
//                генерируем айдишник сами и передаем в конструктор
        } else {
            String param = Arrays.stream(params).toList().get(0);
            if (this.checkFormatId(param) && this.checkUniqueId(param, collectionOfMusicBand)) {
                System.out.println("good id");
                return Long.parseLong(param);
//                     передаем айдишник в конструктор карточки
            } else {
                if (!this.checkFormatId(param)) {
                    System.out.println("Enter id in format 1-18 digits only. Try again or enter null");
                } else if (!this.checkUniqueId(param, collectionOfMusicBand)) {
                    System.out.println("This id already exists. Try again");
                }
                this.whileBlock(in, collectionOfMusicBand);
            }

        }
        return null;
    }
    

    private Boolean checkUniqueId(String str, CollectionOfMusicBand collectionOfMusicBand) throws NumberFormatException{
        boolean flag = true;
        try {
            Long id = Long.parseLong(str);
            for (MusicBand musicBand : collectionOfMusicBand.getCollectionOfCards().values()) {
                if (id.equals(musicBand.getId())) {
                    flag = false;
                    break;
                }
            }
        } catch (NumberFormatException exception) {
            return false;
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

    private Long whileBlock(@NotNull Scanner in, CollectionOfMusicBand collectionOfMusicBand) {
        while (true) {
            String id = in.nextLine();
            if (this.checkNotNullId(id) && this.checkFormatId(id) && this.checkUniqueId(id, collectionOfMusicBand)) {
                System.out.println("success!");
                // айдишник корректен, выходим из цикла
                return Long.parseLong(id);
            } else {
                if (!this.checkNotNullId(id)) {
                    System.out.println("Id will be generated");
                    // генерируем айдишник сами и передаем в конструктор
                    break;
                } else if (!this.checkFormatId(id)) {
                    System.out.println("Enter id in format 1-18 digits only. Try again or enter null");
                } else if (!this.checkUniqueId(id, collectionOfMusicBand)) {
                    System.out.println("This id already exists. Try again");
                } else {
                    System.out.println("Bad id. Try again");
                }
            }
        }
        return null;
    }
}
