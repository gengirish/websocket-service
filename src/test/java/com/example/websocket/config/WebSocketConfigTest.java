package com.example.websocket.config;

import org.junit.jupiter.api.*;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.StompWebSocketEndpointRegistration;

import static org.mockito.Mockito.*;

/**
 * Unit test for WebSocketConfig class to verify WebSocket configuration settings.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WebSocketConfigTest {

    private WebSocketConfig webSocketConfig;
    private MessageBrokerRegistry messageBrokerRegistry;
    private StompEndpointRegistry stompEndpointRegistry;
    private StompWebSocketEndpointRegistration stompWebSocketEndpointRegistration;

    /**
     * Sets up mock dependencies before each test execution.
     */
    @BeforeEach
    void setUp() {
        webSocketConfig = new WebSocketConfig();
        messageBrokerRegistry = mock(MessageBrokerRegistry.class);
        stompEndpointRegistry = mock(StompEndpointRegistry.class);
        stompWebSocketEndpointRegistration = mock(StompWebSocketEndpointRegistration.class);

        // Mock the return values to prevent NullPointerException
        when(stompEndpointRegistry.addEndpoint("/ws")).thenReturn(stompWebSocketEndpointRegistration);
        when(stompWebSocketEndpointRegistration.setAllowedOrigins("*")).thenReturn(stompWebSocketEndpointRegistration);
    }

    @Nested
    @DisplayName("Message Broker Configuration Tests")
    class MessageBrokerConfigTests {

        /**
         * Tests if the message broker configuration is set correctly.
         */
        @Test
        @DisplayName("Should configure message broker with correct prefixes and simple broker")
        void shouldConfigureMessageBrokerCorrectly() {
            webSocketConfig.configureMessageBroker(messageBrokerRegistry);
            verify(messageBrokerRegistry).enableSimpleBroker("/topic");
            verify(messageBrokerRegistry).setApplicationDestinationPrefixes("/app");
        }
    }

    @Nested
    @DisplayName("STOMP Endpoint Registration Tests")
    class StompEndpointConfigTests {

        /**
         * Tests if the STOMP endpoint registration is configured properly.
         */
        @Test
        @DisplayName("Should register STOMP endpoints correctly")
        void shouldRegisterStompEndpointsCorrectly() {
            webSocketConfig.registerStompEndpoints(stompEndpointRegistry);
            verify(stompEndpointRegistry).addEndpoint("/ws");
            verify(stompWebSocketEndpointRegistration).setAllowedOrigins("*");
            verify(stompWebSocketEndpointRegistration).withSockJS();
        }
    }
}

