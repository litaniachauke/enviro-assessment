package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.service.implementations;

import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.dto.AccountProfileDTO;
import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.service.services.AccountProfileService;
import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.service.services.ImageServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class ImageServicesImplementationTest {

    @Autowired
    private ImageServices imageServices;
    @Autowired
    private AccountProfileService accountServiceImplementation;

    @Test
    void getImageLink() throws IOException {
        List<AccountProfileDTO> accountProfileDTOS = accountServiceImplementation.
                addAccountServicesByCSVFile(convertLocalFileToMultipartFile("src/test/Resources/test.csv"));
        FileSystemResource image = imageServices.getImageLink("Enviro365", "IT Solutions");
        assertEquals(accountProfileDTOS.get(0).httpImageLink().getPath(),image.getURI().getPath());
    }
    public MultipartFile convertLocalFileToMultipartFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        return new MockMultipartFile(file.getName(), file.getName(), "application/octet-stream", fileInputStream);
    }
}