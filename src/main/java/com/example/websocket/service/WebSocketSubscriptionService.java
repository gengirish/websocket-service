package com.example.websocket.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Service to manage WebSocket client subscriptions.
 * Tracks active WebSocket sessions and provides utilities for managing connections.
 */
@Service
public class WebSocketSubscriptionService {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketSubscriptionService.class);
    private final Set<WebSocketSession> activeSessions = Collections.synchronizedSet(new HashSet<>());

    /**
     * Registers a new WebSocket session.
     *
     * @param session the WebSocket session to register.
     */
    public void addSession(WebSocketSession session) {
        activeSessions.add(session);
        logger.info("New WebSocket session added: {}", session.getId());
    }

    /**
     * Removes a WebSocket session when a client disconnects.
     *
     * @param session the WebSocket session to remove.
     */
    public void removeSession(WebSocketSession session) {
        activeSessions.remove(session);
        logger.info("WebSocket session removed: {}", session.getId());
    }

    /**
     * Retrieves the current active WebSocket sessions.
     *
     * @return a set of active WebSocket sessions.
     */
    public Set<WebSocketSession> getActiveSessions() {
        return Collections.unmodifiableSet(activeSessions);
    }

    /**
     * Clears all active WebSocket sessions.
     */
    public void clearAllSessions() {
        activeSessions.clear();
    }

}
