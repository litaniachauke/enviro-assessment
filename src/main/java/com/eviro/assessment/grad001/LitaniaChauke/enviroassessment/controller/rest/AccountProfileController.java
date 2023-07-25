package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.controller.rest;

import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.dto.AccountProfileDTO;
import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.service.services.AccountProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("v1/api/account/profile")
public class AccountProfileController {

    @Autowired
    private AccountProfileService accountProfileService;
    @PostMapping("/add/account")
    public List<AccountProfileDTO> addAccountProfiles(MultipartFile file){
        try {
            return accountProfileService.addAccountServicesByCSVFile(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
