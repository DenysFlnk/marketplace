package com.teamchallenge.marketplace.service.s3;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class S3Image {
    private final String key;

    private final ImageType type;

    private final byte[] img;

    public S3Image(ImageType type, int entityId, int imgId, MultipartFile img) {
        this.type = type;
        this.key = createImageKey(type, entityId, imgId);
        try {
            this.img = img.getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e); //todo
        }
    }

    private String createImageKey(ImageType type, int entityId, int imgId) {
        return String.format("%s%s-%s.img", type.name().toLowerCase(), entityId, imgId);
    }

    public String getKey() {
        return key;
    }

    public ImageType getType() {
        return type;
    }

    public byte[] getImg() {
        return img;
    }
}
