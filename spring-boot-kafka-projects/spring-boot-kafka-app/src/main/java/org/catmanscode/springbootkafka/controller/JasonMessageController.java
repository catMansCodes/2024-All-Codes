package org.catmanscode.springbootkafka.controller;

import org.catmanscode.springbootkafka.kafka.JsonKafkaProducer;
import org.catmanscode.springbootkafka.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class JasonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    public JasonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    //POST: https:localhost:8080/api/v1/kafka/producer

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessageToJasonProducer(@RequestBody User userData){

        jsonKafkaProducer.sendMessage(userData);

        return ResponseEntity.ok("Json Message Sent successfully");
    }
}
