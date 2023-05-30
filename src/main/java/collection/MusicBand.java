package collection;

import com.opencsv.bean.CsvDate;
import java.time.LocalDate;

public class MusicBand {

    private Long id;
    private String name;
    private Coordinates coordinates;
    @CsvDate(value = "yyyy-MM-dd")
    private LocalDate creationDate;

    private Long numberOfParticipants;
    private int singlesCount;
    private Integer albumsCount;
    private MusicGenre genre;
    private Label label;

    public MusicBand() {
    }


    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Long getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public int getSinglesCount() {
        return this.singlesCount;
    }

    public Integer getAlbumsCount() {
        return this.albumsCount;
    }

    public MusicGenre getGenre() {
        return this.genre;
    }

    public Label getLabel() {
        return this.label;
    }

    public MusicBand(CardBuilder cardBuilder) {
        this.id = cardBuilder.id;
        this.name = cardBuilder.name;
        this.coordinates = cardBuilder.coordinates;
        this.creationDate = cardBuilder.creationDate;
        this.numberOfParticipants = cardBuilder.numberOfParticipants;
        this.singlesCount = cardBuilder.singlesCount;
        this.albumsCount = cardBuilder.albumsCount;
        this.genre = cardBuilder.genre;
        this.label = cardBuilder.label;

    }

    public static class CardBuilder {
        private Long id;
        private String name;
        private Coordinates coordinates;
        private LocalDate creationDate;
        private Long numberOfParticipants;
        private int singlesCount;
        private Integer albumsCount;
        private MusicGenre genre;
        private Label label;

        public CardBuilder() {
        }

        public CardBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public CardBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CardBuilder setCoordinates(Coordinates coordinates) {
            this.coordinates = coordinates;
            return this;
        }

        public CardBuilder setCreationDate(LocalDate creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public CardBuilder setNumberOfParticipants(Long numberOfParticipants) {
            this.numberOfParticipants = numberOfParticipants;
            return this;
        }

        public CardBuilder setSinglesCount(int singlesCount) {
            this.singlesCount = singlesCount;
            return this;
        }

        public CardBuilder setAlbumCount(Integer albumsCount) {
            this.albumsCount = albumsCount;
            return this;
        }

        public CardBuilder setGenre(MusicGenre genre) {
            this.genre = genre;
            return this;
        }

        public CardBuilder setLabel(Label label) {
            this.label = label;
            return this;
        }

        public MusicBand build() {
            return new MusicBand(this);

        }
    }
}