package commands;

import collection.CollectionOfMusicBand;

public abstract class Command {
    protected String name;
    protected String description;
    protected CollectionOfMusicBand collectionOfMusicBand;

    public Command(String name, String description, CollectionOfMusicBand collectionOfMusicBand) {
        this.name = name;
        this.description = description;
        this.collectionOfMusicBand = collectionOfMusicBand;

    }

    public String getDescription() {
        return this.toString();
    }

    public String toString() {
        return "Command " + "'" + name + "'" + description;
    }

    public void execute() {
    }

}