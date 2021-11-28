package com.example.assignment.controller

import com.example.assignment.dto.CreateCardDetail
import com.example.assignment.kafka.KafkaProducer
import com.example.assignment.service.CardDetailService
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.web.bind.annotation.*
import java.io.Serializable

@RestController
@RequestMapping("/card-detail")
class CardDetailController(
    private val cardDetailService: CardDetailService,
    private val kafkaProducer: KafkaProducer
) {

    @PostMapping("/create-account")
    fun createAccount(@RequestBody input: CardDetailInput) = cardDetailService.createAccount(
        cardNumber = input.cardNumber,
        password = input.password,
        cash = input.cash
    )

    @PostMapping("/make-payment")
    fun makePayment(@RequestBody input: CardDetailInput) = cardDetailService.createAccount(
        cardNumber = input.cardNumber,
        password = input.password,
        cash = input.cash
    )

    @GetMapping("/test-kafka")
    fun testKafka() {
        kafkaProducer.sendMessage(
            topic = "create-card-topic",
            message = jacksonObjectMapper().writeValueAsString(
                CreateCardDetail(
                    cardNumber = "123",
                    password = "123",
                    cash = 100.0
                )
            )
        )
    }
}

data class CardDetailInput(
    val cardNumber: String,
    val password: String,
    val cash: Double
) : Serializable
