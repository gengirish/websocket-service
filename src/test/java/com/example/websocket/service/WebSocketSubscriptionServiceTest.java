package com.example.websocket.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import static org.mockito.Mockito.*;

/**
 * Test class for {@link WebSocketSubscriptionService}.
 * Verifies the handling of WebSocket connection and disconnection events.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
class WebSocketSubscriptionServiceTest {

    @Mock
    private SimpMessageSendingOperations messagingTemplate;

    @InjectMocks
    private WebSocketSubscriptionService subscriptionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests the handling of client connection events.
     */
    @Test
    void testHandleWebSocketConnectListener() {
        SessionConnectedEvent event = mock(SessionConnectedEvent.class);
        SimpMessageHeaderAccessor headers = mock(SimpMessageHeaderAccessor.class);
        when(event.getMessage()).thenReturn(headers);
        when(headers.getSessionId()).thenReturn("session-123");

        subscriptionService.handleWebSocketConnectListener(event);

        verify(headers).getSessionId();
        assert subscriptionService.getActiveSessions().contains("session-123");
    }

    /**
     * Tests the handling of client disconnection events.
     */
    @Test
    void testHandleWebSocketDisconnectListener() {
        SessionDisconnectEvent event = mock(SessionDisconnectEvent.class);
        SimpMessageHeaderAccessor headers = mock(SimpMessageHeaderAccessor.class);
        when(event.getMessage()).thenReturn(headers);
        when(headers.getSessionId()).thenReturn("session-123");

        subscriptionService.handleWebSocketDisconnectListener(event);

        verify(headers).getSessionId();
        assert !subscriptionService.getActiveSessions().contains("session-123");
    }
}