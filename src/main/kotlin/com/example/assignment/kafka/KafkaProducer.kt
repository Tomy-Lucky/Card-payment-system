package com.example.assignment.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    fun sendMessage(message: String, topic: String) {
        kafkaTemplate.send(topic, message)
    }
}