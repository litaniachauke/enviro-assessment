package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.parser;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public interface FileParser {
    void parseCSV(File csvfile);
    File convertCSVDataToImage(String base64ImageData, String format) throws IOException;
    URI createImageLink(File fileImage);
}
