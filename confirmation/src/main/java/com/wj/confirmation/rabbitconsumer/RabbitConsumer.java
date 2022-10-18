package com.wj.confirmation.rabbitconsumer;

import com.wj.clients.confirmation.ConfirmationCheckResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitConsumer {

    @RabbitListener(queues = "confirmation.queue")
    public void consumer(ConfirmationCheckResponse confirmationCheckResponse){
        if(confirmationCheckResponse.confirmed()) log.info("Registration has been successful");
        else log.info("Registration failed.");
    }
}
