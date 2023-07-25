package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.parser;

import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.entities.AccountCSV;
import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.entities.AccountProfile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public interface FileParser {
    List<AccountCSV> parseCSV(MultipartFile csvFile) throws IOException;
    File convertCSVDataToImage(String base64ImageData, String format) throws IOException;
    URI createImageLink(File fileImage) throws URISyntaxException;
}
