package commands;

import collection.CollectionOfMusicBand;

import java.io.IOException;

public abstract class Command {
    protected CollectionOfMusicBand collectionOfMusicBand;
    private String[] params;

    public Command(CollectionOfMusicBand collectionOfMusicBand, String... params) {
        this.collectionOfMusicBand = collectionOfMusicBand;
        this.params = params;

    }

    public String getDescriptionCommand() {
        return this.toString();
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] list) {
        this.params = list;
    }

    public String toString() {
        return "Command " + "'" + this.getName() + "'" + this.getDescription();
    }

    public void execute() throws IOException {
    }

    public String getName() {
        return null;
    }

    public String getDescription() {
        return null;
    }

}