package cmd;

import collection.*;
import commands.EnumExistException;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilityMethods {
    Scanner in;

    public UtilityMethods() {
        this.in = new Scanner(System.in);
    }

    public Long getIdFromUserToSet(CollectionController collectionController, String[] params) {
        if (params.length == 0) {
            System.out.println("Id will be generated");
            IdGenerator idGenerator = new IdGenerator(collectionController);
            return idGenerator.getUniqueId();
        } else {
            String param = params[0];
            if (checkLongFormat(param) && checkUniqueId(param, collectionController)) {
                return Long.parseLong(param);
            } else {
                if (!checkLongFormat(param)) {
                    System.out.println("Enter id in format 1-18 digits only. Try again or enter null");
                } else if (!checkUniqueId(param, collectionController)) {
                    System.out.println("This id already exists. Try again");
                }
                return this.whileBlock(in, collectionController);
            }

        }
    }

    public Boolean checkUniqueId(String str, CollectionController collectionController) {
        boolean flag = true;
        try {
            Long id = Long.parseLong(str);
            for (MusicBand musicBand : collectionController.getCollectionOfCards().values()) {
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
        String longFormatRegex = "^[0-9]{1,18}$";
        Pattern pattern = Pattern.compile(longFormatRegex);
        Matcher mather = pattern.matcher(str);
        if (!mather.matches()) {
            flag = false;
        }
        return flag;
    }


    private Long whileBlock(@NotNull Scanner in, CollectionController collectionController) {
        while (true) {
            String id = in.nextLine().trim();
            if ((id.length() != 0) && checkLongFormat(id) && checkUniqueId(id, collectionController)) {
                return Long.parseLong(id);
            } else {
                if (id.length() == 0) {
                    System.out.println("Id will be generated");
                    IdGenerator idGenerator = new IdGenerator(collectionController);
                    return idGenerator.getUniqueId();
                } else if (!checkLongFormat(id)) {
                    System.out.println("Enter id in format 1-18 digits only. Try again or enter null");
                } else if (!checkUniqueId(id, collectionController)) {
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
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Format X must be Double");
            }
        }
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
        new EnumExistException().offerAvailableEnums();
        while (true) {
            String line = in.nextLine().trim();
            for (MusicGenre genre : MusicGenre.values()) {
                if ((genre.number.toString()).equals(line)) {
                    return genre;
                }
            }
            System.out.println("Choose one of the items. Enter number");
            new EnumExistException().offerAvailableEnums();
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

    public MusicBand getNewCard(CollectionController collectionController, String[] params) {
        UtilityMethods utilityMethods = new UtilityMethods();
        Long id = utilityMethods.getIdFromUserToSet(collectionController, params);
        String name = utilityMethods.getNameFromUser();
        Double x = utilityMethods.getXFromUser();
        int y = utilityMethods.getYFromUser();
        Coordinates coordinates = new Coordinates(x, y);
        LocalDate localDate = LocalDate.now();
        Long numberOfParticipant = utilityMethods.getNumberOfParticipantFromUser();
        int singleCount = utilityMethods.getSingleCountFromUser();
        Integer albumCount = utilityMethods.getAlbumCountFromUser();
        MusicGenre musicGenre = utilityMethods.getMusicGenreFromUser();
        String labelName = utilityMethods.getLabelNameFromUser();
        int labelBands = utilityMethods.getSLabelBandsFromUser();
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
