package collection;

public class Card {
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