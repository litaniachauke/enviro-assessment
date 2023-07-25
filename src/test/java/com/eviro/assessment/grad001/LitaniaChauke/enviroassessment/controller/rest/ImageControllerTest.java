package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.controller.rest;

import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.dto.AccountProfileDTO;
import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.service.services.AccountProfileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ImageControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private ImageController imageController;
    @Autowired
    private AccountProfileService accountProfileService;
    @Test
    void getHttpImageLink() throws Exception {
       List<AccountProfileDTO> accountProfileDTOS = accountProfileService.
                addAccountServicesByCSVFile(convertLocalFileToMultipartFile("src/test/Resources/test.csv"));
        mockMvc = MockMvcBuilders.standaloneSetup(imageController).build();
        mockMvc.perform(MockMvcRequestBuilders.
                get("/v1/api/image/{name}/{surname}", "Enviro365", "IT Solutions"))
                .andExpect(status().isOk());
    }
    public MultipartFile convertLocalFileToMultipartFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        return new MockMultipartFile(file.getName(), file.getName(), "application/octet-stream", fileInputStream);
    }
}