package com.teamchallenge.marketplace.service.s3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.teamchallenge.marketplace.config.AmazonS3Config;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

import static com.amazonaws.services.s3.model.CannedAccessControlList.PublicRead;

@Service
@AllArgsConstructor
public class S3Service {
    private AmazonS3Client client;

    private AmazonS3Config config;

    public String uploadImg(S3Image image) {
        PutObjectRequest request = new PutObjectRequest(config.getBucketName(), image.getKey(),
                new ByteArrayInputStream(image.getImg()), null)
                .withCannedAcl(PublicRead);
        client.putObject(request);

        return client.getResourceUrl(config.getBucketName(), image.getKey());
    }
}
