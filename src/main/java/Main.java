import collection.CollectionController;
import cmd.Executor;
import java.io.File;


public class Main {
    public static void main(String[] args) {
//      File file = new File(args[0]);
        File fileTest = new File("C:\\Users\\alicc\\IdeaProjects\\ApplicationLab5\\collection.csv");
        CollectionController collectionController = new CollectionController();
        Executor executor = new Executor(System.in, collectionController, fileTest);
        executor.start();
    }
}