package collection;


import com.opencsv.bean.CsvBindByPosition;

public class Coordinates {

    @CsvBindByPosition(position = 2)
    private Double x;
    @CsvBindByPosition(position = 3)
    private int y;

    public Coordinates( Double x, int y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return this.x;
    }
    public Double setX(Double x) {
        this.x = x;
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    public int setY(int y) {
        this.y = y;
        return this.y;
    }
}
