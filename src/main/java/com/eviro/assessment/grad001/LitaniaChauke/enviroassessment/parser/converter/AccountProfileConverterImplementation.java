package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.parser.converter;

import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.entities.AccountProfile;
import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.parser.FileParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URI;

public class AccountProfileConverterImplementation {

    private final FileParser fileParser;

    @Autowired
    public AccountProfileConverterImplementation(FileParser fileParser) {
        this.fileParser = fileParser;
    }

    public AccountProfile getAccountProfileFromCSV(String line) throws IOException {
        String[] fields = line.split(",");
        return new AccountProfile(fields[0],fields[1],fileParser.convertCSVDataToImage(fields[2],fields[3]).toURI());
    }
}
