package collection;

import com.opencsv.bean.CsvBindByPosition;

public class Card {
    @CsvBindByPosition(position = 0)
    private String id;

    @CsvBindByPosition(position = 1)
    private String name;

    @CsvBindByPosition(position = 2)
    private String surname;

    public Card() {}

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }


    MusicBand musicBand;
    Coordinates coordinates;
    Label label;
    MusicGenre musicGenre;
    public Card(MusicBand musicBand, Coordinates  coordinates, Label label, MusicGenre musicGenre) {
        this.musicBand = musicBand;
        this.coordinates = coordinates;
        this.label = label;
        this.musicGenre = musicGenre;
    }


}