package commands;

import collection.CollectionController;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.util.concurrent.Executor;
import cmd.Executor;

public class InfoCommand extends Command {

    public InfoCommand(String name, String description, CollectionController collectionController, CommandSet commands) {
        super(name, description, collectionController, commands);
    }

    @Override
    public void execute() {
        System.out.println("-INFORMATION ABOUT COLLECTION-");
        System.out.println("Type of collection: " + collectionController.getName());
        System.out.println("Date of initialization : " + getDateOfInitialisation(Executor.getInstance().getFile()));
        System.out.println("Number of card : " + collectionController.getNumberOfCardsOfCards());
    }

    private String getDateOfInitialisation(File file) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(file.lastModified());
        return dateFormat.format(calendar.getTime());
    }
}
