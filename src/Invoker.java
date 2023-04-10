import java.util.LinkedHashMap;
import java.util.Map;

public class Invoker {
    private int d;

    public void d1() {
    }

    Invoker() {
        System.out.println("constr");
    }

    {
        System.out.print("");
    }


    public LinkedHashMap<String, Command> p() {
        HelpCommand hc = new HelpCommand();
        LinkedHashMap<String, Command> commands = new LinkedHashMap<>();
        commands.put("help", hc);

        return commands;


    }


}