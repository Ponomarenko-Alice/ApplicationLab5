package commands;

import collection.CollectionController;
import exceptions.ExitException;

public class ExitCommand extends Command {
    public ExitCommand(String name, String description, CollectionController collectionController, CommandSet commands, String... params) {
        super(name, description, collectionController, commands, params);
    }

    @Override
    public void execute() throws ExitException {
        throw new ExitException("Bye :З");
    }
}
