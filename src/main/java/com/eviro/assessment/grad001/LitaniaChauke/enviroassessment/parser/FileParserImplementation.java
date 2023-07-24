package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.parser;

import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.entities.AccountProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
@Service
public class FileParserImplementation implements FileParser{

    private List<AccountProfile> accountProfiles = new ArrayList<>();

    @Override
    public void parseCSV(File csvfile) {


    }

    @Override
    public File convertCSVDataToImage(String base64ImageData, String format) throws IOException {
        String[] imgFormat = format.split("/");
        File file = new File("image."+imgFormat[1].toLowerCase());
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(Base64.getDecoder().decode(base64ImageData));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    @Override
    public URI createImageLink(File fileImage) {
        return null;
    }
}
