package collection;

public class Coordinates {

    private Double x;

    private int y;

    public Coordinates( Double x, int y) {
        this.x = x;
        this.y = y;
    }
    public Coordinates() {}

    public Double getX() {
        return x;
    }
    public Double setX(Double x) {
        this.x = x;
        return this.x;
    }

    public int getY() {
        return y;
    }
    public int setY(int y) {
        this.y = y;
        return this.y;
    }
}
