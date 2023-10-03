package com.example.alanfernandes.kafka.example.dtos;

public class ObjectStorage {
    private String url;
    private String id;

    private String bucket;

    private String extension;

    public ObjectStorage() {
    }

    public ObjectStorage(String url, String id, String bucket, String extension) {
        this.url = url;
        this.id = id;
        this.bucket = bucket;
        this.extension = extension;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

}
