package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.service.implementations;

import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.dto.AccountProfileDTO;
import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.entities.AccountProfile;
import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.service.services.AccountProfileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AccountServiceImplementationTest {
    @Autowired
    private AccountProfileService accountServiceImplementation;
    private final List<AccountProfile> testAccounts;

    @Autowired
    public AccountServiceImplementationTest() {
        this.testAccounts = new ArrayList<>();
        testAccounts.add(new AccountProfile("Enviro365", "IT Solutions", URI.create("")));
        testAccounts.add(new AccountProfile("Momentum", "Health", URI.create("")));
    }

    @Test
    void addAccountServicesByCSVFile() throws IOException {
        List<AccountProfileDTO> accountProfileDTOS = accountServiceImplementation.addAccountServicesByCSVFile(convertLocalFileToMultipartFile("src/test/Resources/test.csv"));

        assertEquals(testAccounts.get(0).getName(), accountProfileDTOS.get(0).name());
        assertEquals(testAccounts.get(1).getName(), accountProfileDTOS.get(1).name());
    }

    public MultipartFile convertLocalFileToMultipartFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        return new MockMultipartFile(file.getName(), file.getName(), "application/octet-stream", fileInputStream);
    }
}