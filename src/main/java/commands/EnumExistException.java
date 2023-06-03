package commands;

import collection.MusicGenre;

public class EnumExistException extends Exception {
    public EnumExistException() {
    }


    public void offerAvailableEnums() {
        System.out.println("Enter one of:");
        for (MusicGenre genre : MusicGenre.values()) {
            System.out.println("- " + genre);
        }
    }
}
