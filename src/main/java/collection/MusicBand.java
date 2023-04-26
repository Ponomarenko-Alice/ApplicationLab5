package collection;


import com.opencsv.bean.CsvBindByPosition;

import java.time.LocalDate;

public class MusicBand {
    @CsvBindByPosition(position = 0)
    private Long id;
    @CsvBindByPosition(position = 1)
    private String name;

    private Coordinates coordinates;

    private LocalDate creationDate;

    private Long numberOfParticipants;

    private int singlesCount;

    private Integer albumsCount;

    private MusicGenre genre;
    private Label label;

    public MusicBand() {}
    public MusicBand(Long id, String name, Coordinates coordinates,
                     LocalDate creationDate, Long numberOfParticipants, int singlesCount,
                     Integer albumsCount, MusicGenre genre, Label label) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.numberOfParticipants = numberOfParticipants;
        this.singlesCount = singlesCount;
        this.albumsCount = albumsCount;
        this.genre = genre;
        this.label = label;
    }

    public Long getId() {
        return this.id;
    }

    public Long setId(Long id) {
        this.id = id;
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public Coordinates setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
        return coordinates;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public LocalDate setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return creationDate;
    }

    public Long getNumberOfParticipants() {
        return this.numberOfParticipants;
    }

    public Long setNumberOfParticipants(Long numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
        return numberOfParticipants;
    }

    public int getSinglesCount() {
        return this.singlesCount;
    }

    public int setSinglesCount(int singlesCount) {
        this.singlesCount = singlesCount;
        return singlesCount;
    }

    public Integer getAlbumsCount() {
        return this.albumsCount;
    }

    public Integer setAlbumCount(Integer albumsCount) {
        this.albumsCount = albumsCount;
        return albumsCount;
    }

    public MusicGenre getGenre() {
        return this.genre;
    }

    public MusicGenre setGenre(MusicGenre genre) {
        this.genre = genre;
        return genre;
    }

    public Label getLabel() {
        return this.label;
    }

    public Label setLabel(Label label) {
        this.label = label;
        return label;
    }
}
