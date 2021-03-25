package com.asia.ph.kyc.core.namescreen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NameScreeningService {

    private final KafkaTemplate<String, Object> nameScreenKafkaTemplate;

    @Value(value = "${spring.kafka.producer.topic}")
    private String TOPIC;

    @Autowired
    public NameScreeningService(KafkaTemplate<String, Object> nameScreenKafkaTemplate) {
        this.nameScreenKafkaTemplate = nameScreenKafkaTemplate;
    }

    public void nameScreen(NameScreenRequest nameScreenRequest) {
        nameScreenKafkaTemplate.send(TOPIC, nameScreenRequest);
    }

    @KafkaListener(topics = "#{'${spring.kafka.consumer.topic}'}")
    public void nameScreenConsumer(NameScreenRequest nameScreenRequest,
                                   Acknowledgment acknowledgment,
                                   @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.info("Received name screen request: {}", nameScreenRequest);
        acknowledgment.acknowledge();
    }

}
