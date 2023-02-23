package collection;

public class Label {
    private String name;
    private int bands;

    public Label(String name, int bands) {
        this.name = name;
        this.bands = bands;
    }

    public String getName() {
        return this.name;
    }
    public String setY(String name) {
        this.name = name;
        return this.name;
    }

    public int getBands() {
        return this.bands;
    }
    public int setBands(int bands) {
        this.bands = bands;
        return this.bands;
    }

}
