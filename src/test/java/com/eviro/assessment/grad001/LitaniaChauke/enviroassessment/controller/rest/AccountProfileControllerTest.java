package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.controller.rest;

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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AccountProfileControllerTest {

    @Autowired
    private AccountProfileController accountProfileController;
    private MockMvc mockMvc;

    @Test
    void addAccountProfiles() throws Exception {
        File file = new File("src/test/Resources/test.csv");
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", file.getName(), "application/octet-stream", new FileInputStream(file));
        mockMvc = MockMvcBuilders.standaloneSetup(accountProfileController).build();
        mockMvc.perform(MockMvcRequestBuilders.multipart("/v1/api/account/profile/add/account").
                        file(mockMultipartFile))
                .andExpect(status().isOk());
    }
    public MultipartFile convertLocalFileToMultipartFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        return new MockMultipartFile(file.getName(), file.getName(), "application/octet-stream", fileInputStream);
    }
}