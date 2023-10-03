package com.example.alanfernandes.kafka.example.kafka;

import com.example.alanfernandes.kafka.example.dtos.ObjectStorage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KafkaConsumer {

    public final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = "${spring.config.activate.kafka.topic}", groupId = "${spring.config.activate.kafka.group-id}")
    public void receive(ObjectStorage consumerRecord) throws InterruptedException {
        System.out.println(consumerRecord);
    }
}
