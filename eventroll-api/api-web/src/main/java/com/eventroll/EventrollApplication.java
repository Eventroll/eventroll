package com.eventroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ImportResource("classpath:/com/eventroll/eventroll-api-web-context.xml")
@SpringBootApplication
@EnableJpaRepositories("com.eventroll.repositories")
public class EventrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventrollApplication.class, args);
    }
}
