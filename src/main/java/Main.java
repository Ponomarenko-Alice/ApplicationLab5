import cmd.FileManager;
import collection.CollectionController;
import cmd.Executor;
import exceptions.ExitException;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        CollectionController collectionController = new CollectionController();
        try {
            Executor executor = Executor.init(System.in, collectionController, fileManager.getFile());
            executor.start();
        } catch (ExitException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}