package cmd;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterCSV {

    private final String fileName;
    private final List<String[]> list;

    public WriterCSV(String fileName, List<String[]> list) {
        this.fileName = fileName;
        this.list = list;
    }

    public void writeToFile() throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        CSVWriter csvWriter = new CSVWriter(fileWriter);

        for (String[] line : list) {
            csvWriter.writeNext(line);
        }

        csvWriter.close();
        fileWriter.close();
    }

    public String getFileName() {
        return fileName;
    }

}
