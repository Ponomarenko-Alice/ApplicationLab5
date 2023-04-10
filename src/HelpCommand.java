public class HelpCommand extends Command{
    private final String name;
    private final String description;

    public HelpCommand() {
        name = " help ";
        description = " displays help for available commands";
    }
    public void execute() {
        //
    }

    public String descr() {
        return description;
    }
}
