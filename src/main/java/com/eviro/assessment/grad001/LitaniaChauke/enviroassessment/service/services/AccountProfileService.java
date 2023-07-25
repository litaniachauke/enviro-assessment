package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.service.services;

import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.dto.AccountProfileDTO;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface AccountProfileService {
    List<AccountProfileDTO> addAccountServicesByCSVFile(MultipartFile csvfile) throws IOException;
}
