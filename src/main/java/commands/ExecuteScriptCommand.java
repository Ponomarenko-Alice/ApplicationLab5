package commands;

import cmd.Executor;
import collection.CollectionOfMusicBand;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ExecuteScriptCommand extends Command {
    public ExecuteScriptCommand(String name, String description,CollectionOfMusicBand collectionOfMusicBand, CommandSet commands, String... params) {
        super(name, description, collectionOfMusicBand, commands, params);
    }

    @Override
    public void execute() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Arrays.stream(params).toList().get(0)))) {
            String line;
            Executor executor = new Executor(null, collectionOfMusicBand, null);
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                executor.executeLine(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("File read error. Try different");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No file enter");
        }
    }
}
