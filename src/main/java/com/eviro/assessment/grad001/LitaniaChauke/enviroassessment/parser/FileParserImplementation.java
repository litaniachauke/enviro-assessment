package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.parser;

import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.entities.AccountCSV;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * The type File parser implementation.
 */
@Service
public class FileParserImplementation implements FileParser {

    @Override
    public List<AccountCSV> parseCSV(MultipartFile csvFile) {
        List<AccountCSV> accountProfiles = new ArrayList<>();
        try (Reader reader = new InputStreamReader(csvFile.getInputStream())) {
            try (CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

                for (CSVRecord csvRecord : csvParser) {
                    accountProfiles.add(new AccountCSV(
                            csvRecord.get("name"),
                            csvRecord.get("surname"),
                            csvRecord.get("imageFormat"),
                            csvRecord.get("imageData")
                    ));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accountProfiles;
    }

    @Override
    public File convertCSVDataToImage(String base64ImageData, String format) {
        File file = new File("images/image." + format.toLowerCase());
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(Base64.getDecoder().decode(base64ImageData));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    @Override
    public URI createImageLink(File fileImage) {

        return fileImage.toURI();
    }
}
