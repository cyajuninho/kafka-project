package br.com.cya.kafka_project.producer;

import br.com.cya.kafka_project.dto.UserRequestDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, UserRequestDTO> kafkaTemplate;
    private static final String TOPIC = "cya-topic";

    public KafkaProducer(KafkaTemplate<String, UserRequestDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(UserRequestDTO userRequestDTO) {
        kafkaTemplate.send(TOPIC, userRequestDTO);
    }
}
