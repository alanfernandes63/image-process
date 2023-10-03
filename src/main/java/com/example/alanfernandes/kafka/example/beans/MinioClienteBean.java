package com.example.alanfernandes.kafka.example.beans;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioClienteBean {

    @Bean
    MinioClient getMinioStorageService(@Value("${spring.config.activate.minio.host}") String minioHost,
                                       @Value("${spring.config.activate.minio.port}") String minioPort,
                                       @Value("${spring.config.activate.minio.access-key}") String minioAccessKey,
                                       @Value("${spring.config.activate.minio.secret-key}") String minioSecretKey) {
        return MinioClient.builder()
                .endpoint(minioHost + ":" + minioPort)
                .credentials(minioAccessKey, minioSecretKey)
                .build();

    }
}
