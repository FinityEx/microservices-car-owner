package com.wj.confirmation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@EnableEurekaClient
@SpringBootApplication(
        scanBasePackages = {
                "com.wj.confirmation",
                "com.wj.messageqs"
        }
)
@PropertySources(
        {
                @PropertySource("classpath:clients-${spring.profiles.active}.properties")
        }
)
public class ConfirmationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfirmationApplication.class, args);
    }
}
