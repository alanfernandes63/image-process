package com.example.alanfernandes.kafka.example.controllers;

import com.example.alanfernandes.kafka.example.dtos.ObjectStorage;
import com.example.alanfernandes.kafka.example.services.StorageService;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private KafkaTemplate<String, ObjectStorage> kafkaTemplate;

    @Value("${spring.config.activate.kafka.topic}")
    private String topic;

    @Autowired
    private StorageService storageService;

    @GetMapping("/presigned-url")
    public ResponseEntity<ObjectStorage> getPresignedtUrl(@RequestParam String extension) {
        var id = UUID.randomUUID().toString();
        var secondsExpire = 5000;
        var bucketName = "unprocessed-images";
        var url = storageService.getPresignedObjectUrl(secondsExpire, bucketName, id, extension);

        var minioObject = new ObjectStorage(url, id, bucketName, extension);

        return new ResponseEntity<ObjectStorage>(minioObject, HttpStatusCode.valueOf(200));
    }

    @PutMapping("/process")
    public void imageProcess(@RequestBody ObjectStorage objectStorage) {
        kafkaTemplate.send(topic,objectStorage);
    }
}
