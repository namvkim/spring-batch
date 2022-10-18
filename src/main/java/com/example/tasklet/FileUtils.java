package com.example.tasklet;

import com.opencsv.CSVWriter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


@RequiredArgsConstructor
public class FileUtils {

    private final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    private final String fileName;
    private CSVWriter CSVWriter;
    private FileWriter fileWriter;
    private File file;

    public void writeLine(Product line) throws Exception {
        try {
            if (CSVWriter == null) initWriter();
            String[] lineStr = new String[4];
            lineStr[0] = line.getId().toString();
            lineStr[1] = line.getName();
            lineStr[2] = line.getPrice().toString();
            lineStr[3] = line.getQuantity().toString();
            CSVWriter.writeNext(lineStr);
        } catch (Exception e) {
            logger.error("Error while writing line in file: " + this.fileName);
        }
    }

    private void initWriter() throws Exception {
        if (file == null) {
            file = new File(fileName);
            file.createNewFile();
        }
        if (fileWriter == null) fileWriter = new FileWriter(file, true);
        if (CSVWriter == null) CSVWriter = new CSVWriter(fileWriter);
    }

    public void closeWriter() {
        try {
            CSVWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            logger.error("Error while closing writer.");
        }
    }
}
