package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.User;
import net.javaguides.springboot.publisher.RabbitMqJsonProducer;
import net.javaguides.springboot.publisher.RabbitMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MesageJsonController {
    @Autowired
    private RabbitMqJsonProducer jsonProducer;

    public MesageJsonController(RabbitMqJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    //http://localhost:8080/api/v1/publish
    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        jsonProducer.sendMessage(user);
        return ResponseEntity.ok("JSON message sent to rabbitMQ...");
    }
}
