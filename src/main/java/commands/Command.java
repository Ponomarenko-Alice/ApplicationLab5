package commands;

import collection.CollectionOfMusicBand;

public abstract class Command {
    protected CollectionOfMusicBand collectionOfMusicBand;
    protected CommandSet commands;
    protected String[] params;


    public Command(CollectionOfMusicBand collectionOfMusicBand, CommandSet commands, String... params) {
        this.collectionOfMusicBand = collectionOfMusicBand;
        this.commands = commands;
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
        return "-" + "'" + this.getName() + "'" + this.getDescription();
    }

    public void execute() {
    }

    public String getName() {
        return null;
    }

    public String getDescription() {
        return null;
    }
}