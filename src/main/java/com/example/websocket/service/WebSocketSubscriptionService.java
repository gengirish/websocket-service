package com.example.websocket.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.HashSet;
import java.util.Set;

/**
 * Manages WebSocket subscriptions and tracks active client sessions.
 * This class logs connection and disconnection events and maintains a set of active sessions.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
@Component
public class WebSocketSubscriptionService {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketSubscriptionService.class);

    private final SimpMessageSendingOperations messagingTemplate;
    private final Set<String> activeSessions = new HashSet<>();

    /**
     * Constructs a new {@link WebSocketSubscriptionService} with the given messaging template.
     *
     * @param messagingTemplate the {@link SimpMessageSendingOperations} used to send messages.
     */
    public WebSocketSubscriptionService(SimpMessageSendingOperations messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    /**
     * Handles client connection events.
     *
     * @param event the {@link SessionConnectedEvent} triggered when a client connects.
     */
    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        SimpMessageHeaderAccessor headers = SimpMessageHeaderAccessor.wrap(event.getMessage());
        String sessionId = headers.getSessionId();
        activeSessions.add(sessionId);
        logger.info("Client connected: {}", sessionId);
    }

    /**
     * Handles client disconnection events.
     *
     * @param event the {@link SessionDisconnectEvent} triggered when a client disconnects.
     */
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        SimpMessageHeaderAccessor headers = SimpMessageHeaderAccessor.wrap(event.getMessage());
        String sessionId = headers.getSessionId();
        activeSessions.remove(sessionId);
        logger.info("Client disconnected: {}", sessionId);
    }

    /**
     * Returns the set of active WebSocket sessions.
     *
     * @return a {@link Set} of active session IDs.
     */
    public Set<String> getActiveSessions() {
        return activeSessions;
    }
}