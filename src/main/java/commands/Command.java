package commands;

import collection.CollectionController;

public abstract class Command {
    protected String name;
    protected String description;
    protected CollectionController collectionController;
    protected CommandSet commands;
    protected String[] params;

    public Command(String name, String description, CollectionController collectionController, CommandSet commands, String... params) {
        this.name = name;
        this.description = description;
        this.collectionController = collectionController;
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

    public abstract  void execute() throws ExitException, RecursionScriptException;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}