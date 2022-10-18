package com.wj.messageqs;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String routingKey){
        log.info("Publishing to {} using routing key {}. The payload {}",
                exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
    }

}
