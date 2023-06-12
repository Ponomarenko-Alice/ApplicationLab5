package cmd;

import commands.*;
import exceptions.ExitException;
import exceptions.RecursionScriptException;

import java.util.ResourceBundle;

import static org.apache.commons.lang3.ArrayUtils.remove;

public class LineExecutor {

    public LineExecutor() {
    }

    public void executeLine(final String line, final CommandSet commandSet) throws ExitException, RecursionScriptException {
        try {
            String[] tokens = line.trim().split("\\s+");
            Command command = commandSet.getCommandSet().get(tokens[0]);
            String[] params = remove(tokens, 0);
            if (params.length != 0) {
                command.setParams(params);
            }
            if (command instanceof ExecuteScriptCommand) {
                Executor executor = Executor.getInstance();
                executor.increaseRecursionLevel();
                if (executor.getRecursionLevel() > 1) {
                    String message = ResourceBundle.getBundle("warnings").getString("recursion");
                    throw new RecursionScriptException(message);
                }
            }
            command.execute();

            HistoryCommand historyCommand = commandSet.getCommandSet().values().stream()
                    .filter(x -> x instanceof HistoryCommand)
                    .map(x -> (HistoryCommand) x)
                    .findFirst()
                    .orElse(null);
            historyCommand.addCommandToHistory(tokens[0]);

        } catch (NullPointerException e) {
            String message = ResourceBundle.getBundle("warnings").getString("nonExistedCommand");
            System.out.println(message);
        } catch (ExitException e) {
            throw new ExitException("Bye :з");
        } catch (RecursionScriptException e) {
            String message = ResourceBundle.getBundle("warnings").getString("recursion");
            throw new RecursionScriptException(message);
        }
    }
}
