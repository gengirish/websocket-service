package com.example.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class for the WebSocket application.
 * This class contains the main method which is the entry point of the Spring Boot application.
 */
@SpringBootApplication
public class WebsocketApplication {

	/**
	 * The main method which serves as the entry point for the Spring Boot application.
	 *
	 * @param args Command line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(WebsocketApplication.class, args);
	}
}