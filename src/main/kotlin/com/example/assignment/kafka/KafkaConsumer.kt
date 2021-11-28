package com.example.assignment.kafka

import com.example.assignment.dto.CreateCardDetail
import com.example.assignment.service.CardDetailService
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer(
    private val cardDetailService: CardDetailService
) {

    @KafkaListener(topics = ["create-card-topic"], groupId = "group_id")
    fun consumeCardCreationDetails(cardDetails: String) {
        val createCardDetail = jacksonObjectMapper().readValue(cardDetails, CreateCardDetail::class.java)
        cardDetailService.createAccount(
            cardNumber = createCardDetail.cardNumber,
            password = createCardDetail.password,
            cash = createCardDetail.cash
        )
    }
}