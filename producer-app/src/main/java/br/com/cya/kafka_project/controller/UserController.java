package br.com.cya.kafka_project.controller;

import br.com.cya.kafka_project.dto.UserRequestDTO;
import br.com.cya.kafka_project.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final KafkaProducer kafkaProducer;

    public UserController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/new")
    public ResponseEntity<String> createNewUser(@RequestBody UserRequestDTO userRequestDTO) {

        for (int i = 0; i < 1000000; i++) {
            userRequestDTO.setNumber(i);
            System.out.println("Sending message: " + i);
            kafkaProducer.sendMessage(userRequestDTO);
        }
        return ResponseEntity.ok("User created successfully");
    }
}
