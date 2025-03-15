package com.example.websocket.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Test class for {@link WebSocketConfig}.
 * Verifies the WebSocket configuration and endpoint registration.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
@SpringBootTest
class WebSocketConfigTest {

    @Autowired
    private WebSocketConfig webSocketConfig;

    /**
     * Tests the configuration of the message broker.
     */
    @Test
    void testConfigureMessageBroker() {
        MessageBrokerRegistry registry = mock(MessageBrokerRegistry.class);
        webSocketConfig.configureMessageBroker(registry);

        verify(registry).enableSimpleBroker("/topic");
        verify(registry).setApplicationDestinationPrefixes("/app");
    }

    /**
     * Tests the registration of WebSocket endpoints.
     */
    @Test
    void testRegisterStompEndpoints() {
        StompEndpointRegistry registry = mock(StompEndpointRegistry.class);
        webSocketConfig.registerStompEndpoints(registry);

        verify(registry).addEndpoint("/ws").withSockJS();
    }
}