package commands;

import collection.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandManager {
    Scanner in;

    public CommandManager() {
        this.in = new Scanner(System.in);
    }

    public Long getIdFromUserToSet(CollectionOfMusicBand collectionOfMusicBand, String[] params) {
        if (params.length == 0) {
            System.out.println("Id will be generated");
            IdGenerator idGenerator = new IdGenerator(collectionOfMusicBand);
            return idGenerator.getUniqueId();
        } else {
            String param = Arrays.stream(params).toList().get(0);
            if (this.checkLongFormat(param) && this.checkUniqueId(param, collectionOfMusicBand)) {
                return Long.parseLong(param);
            } else {
                if (!this.checkLongFormat(param)) {
                    System.out.println("Enter id in format 1-18 digits only. Try again or enter null");
                } else if (!this.checkUniqueId(param, collectionOfMusicBand)) {
                    System.out.println("This id already exists. Try again");
                }
                return this.whileBlock(in, collectionOfMusicBand);
            }

        }
    }

    public Boolean checkUniqueId(String str, CollectionOfMusicBand collectionOfMusicBand) {
        boolean flag = true;
        try {
            Long id = Long.parseLong(str);
            for (MusicBand musicBand : collectionOfMusicBand.getCollectionOfCards().values()) {
                if (id.equals(musicBand.getId())) {
                    flag = false;
                    break;
                }
            }
        } catch (NumberFormatException exception) {
            return false;
        }
        return flag;
    }

    /*
    @param String
    @return true if string is Long format
     */
    public Boolean checkLongFormat(String str) {
        boolean flag = true;
        String regex = "^[0-9]{1,18}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher mather = pattern.matcher(str);
        if (!mather.matches()) {
            flag = false;
        }
        return flag;
    }


    private Long whileBlock(@NotNull Scanner in, CollectionOfMusicBand collectionOfMusicBand) {
        while (true) {
            String id = in.nextLine().trim();
            if ((id.length() != 0) && this.checkLongFormat(id) && this.checkUniqueId(id, collectionOfMusicBand)) {
                return Long.parseLong(id);
            } else {
                if (id.length() == 0) {
                    System.out.println("Id will be generated");
                    IdGenerator idGenerator = new IdGenerator(collectionOfMusicBand);
                    return idGenerator.getUniqueId();
                } else if (!this.checkLongFormat(id)) {
                    System.out.println("Enter id in format 1-18 digits only. Try again or enter null");
                } else if (!this.checkUniqueId(id, collectionOfMusicBand)) {
                    System.out.println("This id already exists. Try again");
                } else {
                    System.out.println("Bad id. Try again");
                }
            }
        }
    }

    public String getNameFromUser() {
        System.out.println("Enter name");
        String line = in.nextLine();
        while (line == null || line.length() == 0) {
            System.out.println("Name can't be null. Enter again");
            line = in.nextLine();
        }
        return line;
    }

    public Double getXFromUser() {
        System.out.println("Enter coordinate X");
        while (true) {
            String line = in.nextLine();
            while (line == null || line.length() == 0) {
                System.out.println("Field can't be null. Enter again");
                line = in.nextLine();
            }
            try {
                return parseToDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Format X must be Double");
            }
        }

    }

    private Double parseToDouble(String str) throws NumberFormatException {
        return Double.parseDouble(str);
    }


    public int getYFromUser() {
        System.out.println("Enter coordinate Y");
        while (true) {
            String line = in.nextLine();
            while (line == null || line.length() == 0) {
                System.out.println("Field can't be null. Enter again");
                line = in.nextLine();
            }
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Format Y must be int");
            }
        }

    }

    public Long getNumberOfParticipantFromUser() {
        System.out.println("Enter number of participant");
        while (true) {
            String line = in.nextLine();
            while (line == null || line.length() == 0) {
                System.out.println("Name can't be null. Enter again");
                line = in.nextLine();
            }
            try {
                long numberOfParticipant = Long.parseLong(line.trim());
                if (numberOfParticipant <= 0) {
                    System.out.println("Field must be > 0");
                } else {
                    return numberOfParticipant;
                }
            } catch (NumberFormatException e) {
                System.out.println("Format must be Long");
            }
        }
    }

    public int getSingleCountFromUser() {
        System.out.println("Enter single count");
        while (true) {
            String line = in.nextLine();
            while (line == null || line.length() == 0) {
                System.out.println("Field can't be null. Enter again");
                line = in.nextLine();
            }
            try {
                int singleCount = Integer.parseInt(line.trim());
                if (singleCount <= 0) {
                    System.out.println("Field must be > 0");
                } else {
                    return singleCount;
                }
            } catch (NumberFormatException e) {
                System.out.println("Format must be int");
            }
        }
    }

    public Integer getAlbumCountFromUser() {
        System.out.println("Enter album set");
        while (true) {
            String line = in.nextLine();
            if (line == null || line.length() == 0) {
                return null; // по заданию
            } else {
                try {
                    int albumSet = Integer.parseInt(line.trim());
                    if (albumSet <= 0) {
                        System.out.println("Field must be > 0");
                    } else {
                        return albumSet;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Format must be Integer");
                }
            }
        }
    }

    public MusicGenre getMusicGenreFromUser() {
        System.out.println("Choose one of the items. Enter number");
        System.out.println("1) PSYCHEDELIC_CLOUD_RAP \n2) SOUL \n3) POST_PUNK");

        while (true) {
            String line = in.nextLine();
            switch (line.trim()) {
                case "1":
                    return MusicGenre.PSYCHEDELIC_CLOUD_RAP;
                case "2":
                    return MusicGenre.SOUL;
                case "3":
                    return MusicGenre.POST_PUNK;
                default:
                    System.out.println("Enter number one of: \n1) PSYCHEDELIC_CLOUD_RAP \n2) SOUL \n3) POST_PUNK");
            }
        }


    }

    public String getLabelNameFromUser() {
        System.out.println("Enter label name. It may be null");
        return in.nextLine();
    }

    public int getSLabelBandsFromUser() {
        System.out.println("Enter count of label bands");
        while (true) {
            String line = in.nextLine();
            while (line == null || line.length() == 0) {
                System.out.println("Field can't be null. Enter again");
                line = in.nextLine();
            }
            try {
                int labelBands = Integer.parseInt(line.trim());
                if (labelBands <= 0) {
                    System.out.println("Field must be > 0");
                } else {
                    return labelBands;
                }
            } catch (NumberFormatException e) {
                System.out.println("Format must be int");
            }
        }
    }


    public MusicBand getNewCard(CollectionOfMusicBand collectionOfMusicBand, String[] params) {
        CommandManager commandManager = new CommandManager();
        Long id = commandManager.getIdFromUserToSet(collectionOfMusicBand, params);
        String name = commandManager.getNameFromUser();
        Double x = commandManager.getXFromUser();
        int y = commandManager.getYFromUser();
        Coordinates coordinates = new Coordinates(x, y);
        LocalDate localDate = LocalDate.now();
        Long numberOfParticipant = commandManager.getNumberOfParticipantFromUser();
        int singleCount = commandManager.getSingleCountFromUser();
        Integer albumCount = commandManager.getAlbumCountFromUser();
        MusicGenre musicGenre = commandManager.getMusicGenreFromUser();
        String labelName = commandManager.getLabelNameFromUser();
        int labelBands = commandManager.getSLabelBandsFromUser();
        Label label = new Label(labelName, labelBands);

        return new MusicBand.CardBuilder()
                .setId(id)
                .setName(name)
                .setCoordinates(coordinates)
                .setCreationDate(localDate)
                .setNumberOfParticipants(numberOfParticipant)
                .setSinglesCount(singleCount)
                .setAlbumCount(albumCount)
                .setGenre(musicGenre)
                .setLabel(label)
                .build();
    }


}
