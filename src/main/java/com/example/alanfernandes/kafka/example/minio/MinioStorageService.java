package com.example.alanfernandes.kafka.example.minio;

import com.example.alanfernandes.kafka.example.services.StorageService;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.errors.MinioException;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class MinioStorageService implements StorageService {
    @Autowired
    MinioClient minioClient;

    @Override
    public String getPresignedObjectUrl(int secondsExpire, String bucket, String id, String extension) {
        try {
            return minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .expiry(secondsExpire)
                            .bucket(bucket)
                            .object(id + "." + extension)
                            .method(Method.PUT)
                            .build());
        } catch (MinioException | InvalidKeyException | IOException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
