

public abstract class Command {
    protected String name;
    protected String description;

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return this.toString();
    }

    public String toString() {
        return "Command " + "'" + name + "'" + description;
    }

    public void execute() {
    }

}
