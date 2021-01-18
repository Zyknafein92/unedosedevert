package com.openclassroom.projet12.controller;

import com.openclassroom.projet12.dto.PhotoDTO;
import com.openclassroom.projet12.service.PhotoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AmazonController {

    private final PhotoService photoService;

    @PostMapping("/upload")
    public PhotoDTO upload(@RequestPart(value = "file") MultipartFile file) throws IllegalAccessException {
        return PhotoDTO.builder().urlPhoto(photoService.uploadPhoto(file)).build();
    }
}
