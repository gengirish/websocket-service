package com.example.websocket.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.socket.WebSocketSession;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * Unit tests for WebSocketSubscriptionService.
 * Validates session management, edge cases, and retrieval of active sessions.
 */
class WebSocketSubscriptionServiceTest {
    private WebSocketSubscriptionService subscriptionService;
    private WebSocketSession mockSession1;
    private WebSocketSession mockSession2;
    private WebSocketSession mockSession3;

    @BeforeEach
    void setUp() {
        subscriptionService = new WebSocketSubscriptionService();
        mockSession1 = mock(WebSocketSession.class);
        mockSession2 = mock(WebSocketSession.class);
        mockSession3 = mock(WebSocketSession.class);

        Mockito.when(mockSession1.getId()).thenReturn("session1");
        Mockito.when(mockSession2.getId()).thenReturn("session2");
        Mockito.when(mockSession3.getId()).thenReturn("session3");
    }

    @Test
    @DisplayName("Test adding a new session")
    void testAddSession() {
        subscriptionService.addSession(mockSession1);
        assertTrue(subscriptionService.getActiveSessions().contains(mockSession1));
    }

    @Test
    @DisplayName("Test removing an existing session")
    void testRemoveSession() {
        subscriptionService.addSession(mockSession1);
        subscriptionService.removeSession(mockSession1);
        assertFalse(subscriptionService.getActiveSessions().contains(mockSession1));
    }

    @Test
    @DisplayName("Test retrieving active sessions")
    void testGetActiveSessions() {
        subscriptionService.addSession(mockSession1);
        subscriptionService.addSession(mockSession2);
        Set<WebSocketSession> sessions = subscriptionService.getActiveSessions();
        assertEquals(2, sessions.size());
        assertTrue(sessions.contains(mockSession1));
        assertTrue(sessions.contains(mockSession2));
    }

    @Test
    @DisplayName("Test adding duplicate session")
    void testAddDuplicateSession() {
        subscriptionService.addSession(mockSession1);
        subscriptionService.addSession(mockSession1);
        assertEquals(1, subscriptionService.getActiveSessions().size(), "Duplicate session should not be added");
    }

    @Test
    @DisplayName("Test removing a non-existent session")
    void testRemoveNonExistentSession() {
        subscriptionService.removeSession(mockSession3);
        assertTrue(subscriptionService.getActiveSessions().isEmpty(), "Removing a non-existent session should not affect existing ones");
    }

    @Test
    @DisplayName("Test clearing all sessions")
    void testClearAllSessions() {
        subscriptionService.addSession(mockSession1);
        subscriptionService.addSession(mockSession2);
        subscriptionService.addSession(mockSession3);

        subscriptionService.clearAllSessions();

        assertTrue(subscriptionService.getActiveSessions().isEmpty(), "All sessions should be cleared");
    }

    @Test
    @DisplayName("Test adding and removing multiple sessions")
    void testAddAndRemoveMultipleSessions() {
        subscriptionService.addSession(mockSession1);
        subscriptionService.addSession(mockSession2);
        subscriptionService.addSession(mockSession3);

        subscriptionService.removeSession(mockSession1);

        Set<WebSocketSession> remainingSessions = subscriptionService.getActiveSessions();
        assertEquals(2, remainingSessions.size(), "Only two sessions should remain");
        assertFalse(remainingSessions.contains(mockSession1), "Removed session should not be present");
        assertTrue(remainingSessions.contains(mockSession2));
        assertTrue(remainingSessions.contains(mockSession3));
    }
}
