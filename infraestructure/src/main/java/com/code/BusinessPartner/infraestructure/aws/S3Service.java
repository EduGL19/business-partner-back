package com.code.BusinessPartner.infraestructure.aws;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Service
@RequiredArgsConstructor
public class S3Service {

    @Value("${accessKey.S3}")
    private String accessKeyS3;
    @Value("${secretKey.S3}")
    private String secretKeyS3;
    public PutObjectResult upload(MultipartFile multipartFile, String folder) {

        ObjectMetadata data = new ObjectMetadata();
        data.setContentType(multipartFile.getContentType());
        data.setContentLength(multipartFile.getSize());
        BasicAWSCredentials creds = new BasicAWSCredentials(accessKeyS3, secretKeyS3);
        AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).withCredentials(new AWSStaticCredentialsProvider(creds)).build();

        //PutObjectResult objectResult = s3client.putObject("java-business-partner", multipartFile.getOriginalFilename(), multipartFile.getInputStream(), data);
        File convertedFile = convertMultipartFileToFile(multipartFile);
        PutObjectResult objectResult = s3client.putObject("java-business-partner", folder + multipartFile.getOriginalFilename(), convertedFile);

        //System.out.println(objectResult.getContentMd5()); //you can verify MD5

        return objectResult;
    }

    private File convertMultipartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try {
            Files.copy(file.getInputStream(), convertedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return convertedFile;
    }


}
