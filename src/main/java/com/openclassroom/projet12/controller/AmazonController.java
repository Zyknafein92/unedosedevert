package com.openclassroom.projet12.controller;

import com.openclassroom.projet12.dto.PictureDTO;
import com.openclassroom.projet12.service.PictureService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AmazonController {

    private final PictureService photoService;

    @PostMapping("/upload")
    public PictureDTO upload(@RequestPart(value = "file") MultipartFile file) throws IllegalAccessException {
        return PictureDTO.builder().urlPicture(photoService.uploadPhoto(file)).build();
    }
}
