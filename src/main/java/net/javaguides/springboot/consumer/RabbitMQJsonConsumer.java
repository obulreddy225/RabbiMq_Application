package net.javaguides.springboot.consumer;

import net.javaguides.springboot.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);


    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeMessage(User user){
        LOGGER.info("received Message -> {}", user);

    }
}
