package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.parser;

import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.entities.AccountCSV;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * The interface File parser.
 */
public interface FileParser {
    /**
     * Parse csv list.
     *
     * @param csvFile the csv file
     * @return the list
     * @throws IOException the io exception
     */
    List<AccountCSV> parseCSV(MultipartFile csvFile) throws IOException;

    /**
     * Convert csv data to image file.
     *
     * @param base64ImageData the base 64 image data
     * @param format          the format
     * @return the file
     * @throws IOException the io exception
     */
    File convertCSVDataToImage(String base64ImageData, String format) throws IOException;

    /**
     * Create image link uri.
     *
     * @param fileImage the file image
     * @return the uri
     * @throws URISyntaxException the uri syntax exception
     */
    URI createImageLink(File fileImage) throws URISyntaxException;
}
