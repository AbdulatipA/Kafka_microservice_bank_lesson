package org.example.transactional_service;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic orderSavedTopic(){
        return TopicBuilder
                .name("order-saved-events")
                .partitions(2)
                .replicas(2)
                .build();
    }
}
