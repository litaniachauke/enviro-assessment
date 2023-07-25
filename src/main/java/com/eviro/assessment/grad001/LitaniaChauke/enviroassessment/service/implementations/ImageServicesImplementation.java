package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.service.implementations;

import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.repository.AccountProfileRepository;
import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.service.services.ImageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import java.net.URI;
@Service
public class ImageServicesImplementation implements ImageServices {

    @Autowired
    private AccountProfileRepository accountProfileRepository;
    @Override
    public FileSystemResource getImageLink(String name, String surname) {
        URI imageUri = accountProfileRepository.findByNameAndSurname(name, surname).getHttpImageLink();
        return new FileSystemResource(imageUri.getPath());
    }
}
