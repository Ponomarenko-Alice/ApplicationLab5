package cmd;

import commands.*;

import static org.apache.commons.lang3.ArrayUtils.remove;

public class LineExecutor {

    public LineExecutor() {
    }

    public void executeLine(String line, CommandSet commandSet) throws ExitException, RecursionScriptException {
        try {
            String[] tokens = line.trim().split("\\s+");
            Command command = commandSet.getCommandSet().get(tokens[0]);
            String[] params = remove(tokens, 0);
            if (params.length != 0) {
                command.setParams(params);
            }
            if (command instanceof ExecuteScriptCommand) {
                System.out.println(Executor.getInstance().getRecursionLevel());
                Executor.getInstance().increaseRecursionLevel();
                if (Executor.getInstance().getRecursionLevel() > 1) {
                    throw new RecursionScriptException("Recursion. File has execute_script command."); }
            }
            command.execute();

            HistoryCommand historyCommand = commandSet.getCommandSet().values().stream()
                    .filter(x -> x instanceof HistoryCommand)
                    .map(x -> (HistoryCommand) x)
                    .findFirst()
                    .orElse(null);
            historyCommand.addCommandToHistory(tokens[0]);

        } catch (NullPointerException e) {
            System.out.println("Non-existed command. Try 'help' command for available commands.");
        } catch (ExitException e) {
            throw new ExitException("bye");
        } catch (RecursionScriptException e) {
            throw new RecursionScriptException("Recursion. File has execute_script command.");
        }
    }


}
