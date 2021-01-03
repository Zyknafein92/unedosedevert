package com.openclassroom.projet12.service.utils;

import com.openclassroom.projet12.model.Photo;
import com.openclassroom.projet12.respository.PhotoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Service
@AllArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final AmazonService amazonService;

    public String uploadPhoto(MultipartFile multipartFile) throws IllegalAccessException {
        String fileName = generateUniqueName(multipartFile.getOriginalFilename());
        String url = amazonService.uploadFile(multipartFile,fileName);
        Photo photo = Photo.builder()
                .name(fileName)
                .url(url)
                .build();

        photoRepository.save(photo);
        return url;
    }

    private String generateUniqueName(String fileName) {
        return new Date().getTime() + '-' + fileName.replace(" ", "_");
    }

}
