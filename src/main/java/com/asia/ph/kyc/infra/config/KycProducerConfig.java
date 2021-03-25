package com.asia.ph.kyc.infra.config;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KycProducerConfig {

    @Bean
    public ProducerFactory<String, Object> producerFactory(KafkaProperties kafkaProperties) {
        return new DefaultKafkaProducerFactory(kafkaProperties.buildProducerProperties());
    }

    @Bean
    public KafkaTemplate<String, Object> nameScreenKafkaTemplate(ProducerFactory<String, Object> producerFactory) {
        return new KafkaTemplate(producerFactory);
    }

}
