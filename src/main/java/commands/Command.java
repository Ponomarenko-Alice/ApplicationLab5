package commands;

import collection.CollectionOfMusicBand;

public abstract class Command {
    protected String name;
    protected String description;
    protected CollectionOfMusicBand collectionOfMusicBand;
    protected CommandSet commands;
    protected String[] params;

    public Command(String name, String description, CollectionOfMusicBand collectionOfMusicBand, CommandSet commands, String... params) {
        this.name = name;
        this.description = description;
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
        return name;
    }

    public String getDescription() {
        return description;
    }
}