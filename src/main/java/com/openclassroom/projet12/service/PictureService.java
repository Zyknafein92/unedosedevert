package com.openclassroom.projet12.service;

import com.openclassroom.projet12.model.Picture;
import com.openclassroom.projet12.respository.PictureRepository;
import com.openclassroom.projet12.service.utils.AmazonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Service
@AllArgsConstructor
public class PictureService {

    private final PictureRepository photoRepository;
    private final AmazonService amazonService;

    public String uploadPhoto(MultipartFile multipartFile) throws IllegalAccessException {
        String fileName = generateUniqueName(multipartFile.getOriginalFilename());
        String url = amazonService.uploadFile(multipartFile,fileName);
        Picture picture = Picture.builder()
                .name(fileName)
                .url(url)
                .build();

        photoRepository.save(picture);
        return url;
    }

    private String generateUniqueName(String fileName) {
        return new Date().getTime() + '-' + fileName.replace(" ", "_");
    }

}
