package com.openclassroom.projet12.service.utils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class AmazonService {

    private AmazonS3 service;

    @Value("${amazon.s3.endpoint}")
    private String endpoint;
    @Value("${amazon.s3.bucketName}")
    private String bucketName;
    @Value("${amazon.s3.region}")
    private String region;
    @Value("${amazon.s3.accessKeyId}")
    private String accessKeyId;
    @Value("${amazon.s3.accessKeySecret}")
    private String accessKeySecret;

    @PostConstruct
    private void init() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKeyId, accessKeySecret);
        this.service = AmazonS3ClientBuilder
                .standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }

    public String uploadFile(MultipartFile multipartFile, String fileName) throws IllegalAccessException {
        File file = new File(fileName);
        try(FileOutputStream fos = new FileOutputStream(file)){
            fos.write(multipartFile.getBytes());
        } catch (IOException e) {
            throw new IllegalAccessException("File not found");
        }
        String fileUrl = "https://" + bucketName + "." + endpoint + "/" + fileName;
        service.putObject(bucketName,fileName,file);

        file.delete();

        return fileUrl;
    }

    public void deleteFile(String filename) {
        service.deleteObject(bucketName,filename);
    }

}
