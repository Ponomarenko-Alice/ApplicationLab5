package exceptions;

import collection.MusicGenre;

public class EnumExistException extends Exception {
    public EnumExistException() {
    }

    public void offerAvailableEnums() {
        Integer number = 1;
        for (MusicGenre genre : MusicGenre.values()) {
            System.out.println(number + ") " + genre);
            number++;
        }
    }
}
