package com.example.alanfernandes.kafka.example.services;

public interface StorageService {
    String getPresignedObjectUrl(int secondsExpire, String bucket, String id, String extension);
}
