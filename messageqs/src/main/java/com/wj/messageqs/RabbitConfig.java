package com.wj.messageqs;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class RabbitConfig {

    private final String topicExchange = "exchange";

    private final String confirmationQueue = "confirmation.queue";

    private final String confirmationRoutingKey = "confirmation.routing-key";

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(this.topicExchange);
    }

    @Bean
    public Queue confirmationQueue(){
        return new Queue(this.confirmationQueue);
    }

    @Bean
    public Binding internalToConfirmationBinding(){
        return BindingBuilder.bind(confirmationQueue())
                .to(topicExchange())
                .with(this.confirmationRoutingKey);
    }

    @Bean
    public MessageConverter jacksonConverter(){
        MessageConverter jackson2JsonMessageConverter =
                new Jackson2JsonMessageConverter();
        return jackson2JsonMessageConverter;
    }

}
