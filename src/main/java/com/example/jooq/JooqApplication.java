package com.example.jooq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.jooq")
public class JooqApplication {

	public static void main(String[] args) {
		SpringApplication.run(JooqApplication.class, args);
	}
}
