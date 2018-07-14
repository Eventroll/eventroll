package com.eventroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:/com/eventroll/eventroll-api-web-context.xml")
@SpringBootApplication
public class EventrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventrollApplication.class, args);
	}
}
