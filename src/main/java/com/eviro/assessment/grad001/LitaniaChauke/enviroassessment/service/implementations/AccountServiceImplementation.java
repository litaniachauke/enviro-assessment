package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.service.implementations;

import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.dto.AccountProfileDTO;
import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.entities.AccountCSV;
import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.entities.AccountProfile;
import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.parser.FileParser;
import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.repository.AccountProfileRepository;
import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.service.services.AccountProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImplementation implements AccountProfileService {

    @Autowired
    private FileParser fileParser;
    @Autowired
    private AccountProfileRepository accountProfileRepository;
    @Override
    public List<AccountProfileDTO> addAccountServicesByCSVFile(MultipartFile csvfile) throws IOException {
        List<AccountProfileDTO> accountProfileDTOS = new ArrayList<>();
        List<AccountCSV> accountCSVS = fileParser.parseCSV(csvfile);
        for (AccountCSV accountCSV : accountCSVS) {
            String[] format = accountCSV.getFormat().split("/");
            if(format.length==2){
                accountCSV.setFormat(format[1]);
            }else {
                accountCSV.setFormat("png");
            }
            accountProfileDTOS.add(accountProfileRepository.save(new AccountProfile(accountCSV.getName(),
                    accountCSV.getSurname(),
                    fileParser.convertCSVDataToImage(accountCSV.getBase64ImageData(),accountCSV.getFormat()).toURI())).toAccountProfileDTO());
        }
        return accountProfileDTOS;
    }
}
