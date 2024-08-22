package br.com.cya.kafka_project.listeners;

import org.springframework.stereotype.Service;

@Service
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "cya-topic", groupId = "cyaGroup")
    public void listener(String message) {
        System.out.println("Received message by consumer: " + message);
    }
}
