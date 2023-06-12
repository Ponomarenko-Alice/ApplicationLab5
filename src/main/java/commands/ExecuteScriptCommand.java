package commands;

import cmd.LineExecutor;
import collection.CollectionController;
import exceptions.ExitException;
import exceptions.RecursionScriptException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ExecuteScriptCommand extends Command {

    public ExecuteScriptCommand(String name, String description, CollectionController collectionController, CommandSet commands, String... params) {
        super(name, description, collectionController, commands, params);
    }

    @Override
    public void execute() throws ExitException, RecursionScriptException {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Arrays.stream(params).toList().get(0)))) {
            String line;
            LineExecutor lineExecutor = new LineExecutor();
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                lineExecutor.executeLine(line, commands);
            }
        } catch (IOException e) {
            String message = ResourceBundle.getBundle("warnings").getString("IOException");
            System.out.println(message);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No file enter");
        } catch (RecursionScriptException e) {
            String message = ResourceBundle.getBundle("warnings").getString("nonExistedCommand");
            throw new RecursionScriptException(message);
        }
    }
}
