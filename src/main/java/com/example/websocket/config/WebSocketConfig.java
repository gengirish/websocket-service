package com.example.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Configures WebSocket endpoints and enables STOMP over WebSockets.
 * This class sets up the message broker and registers the WebSocket endpoint.
 *
 * @author Your Name
 * @version 1.0
 * @see WebSocketMessageBrokerConfigurer
 * @since 2023-10-01
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Configures the message broker for WebSocket communication.
     *
     * @param config the {@link MessageBrokerRegistry} to configure.
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Enable a simple in-memory message broker for broadcasting messages
        config.enableSimpleBroker("/topic");
        // Set the prefix for application-specific messages
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * Registers the WebSocket endpoint and enables SockJS fallback.
     *
     * @param registry the {@link StompEndpointRegistry} to register endpoints.
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Register the "/ws" endpoint for WebSocket connections
        registry.addEndpoint("/ws").withSockJS(); // Enable SockJS fallback
    }
}