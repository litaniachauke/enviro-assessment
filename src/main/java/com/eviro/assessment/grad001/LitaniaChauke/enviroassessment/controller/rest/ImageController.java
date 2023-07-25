package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.controller.rest;

import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.service.services.ImageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Image controller.
 */
@RestController
@RequestMapping("/v1/api/image")
public class ImageController {
    @Autowired
    private ImageServices imageServices;

    /**
     * Gets http image link.
     *
     * @param name    the name
     * @param surname the surname
     * @return the http image link
     */
    @GetMapping(value = "/{name}/{surname}")
    public FileSystemResource getHttpImageLink(@PathVariable String name, @PathVariable String surname) {
        return imageServices.getImageLink(name, surname);
    }
}
