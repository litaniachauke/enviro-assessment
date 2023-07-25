package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.service.services;

import org.springframework.core.io.FileSystemResource;

public interface ImageServices {
    FileSystemResource getImageLink(String name, String surname);
}
