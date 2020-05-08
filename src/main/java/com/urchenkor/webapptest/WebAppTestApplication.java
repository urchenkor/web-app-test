package com.urchenkor.webapptest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WebAppTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppTestApplication.class, args);
	}

}
