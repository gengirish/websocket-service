package com.example.websocket.controller;

import com.example.websocket.exception.InvalidMessageException;
import com.example.websocket.model.ChatMessage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for {@link WebSocketMessageController}.
 * Verifies the handling of incoming WebSocket messages.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
class WebSocketMessageControllerTest {

    private WebSocketMessageController messageController = new WebSocketMessageController();

    /**
     * Tests the handling of valid chat messages.
     */
    @Test
    void testSendMessage_ValidMessage() throws InvalidMessageException {
        ChatMessage message = new ChatMessage();
        message.setSender("User");
        message.setContent("Hello, World!");

        ChatMessage result = messageController.sendMessage(message);

        assertEquals("Hello, World!", result.getContent());
        assertEquals("User", result.getSender());
    }

    /**
     * Tests the handling of invalid chat messages (empty content).
     */
    @Test
    void testSendMessage_InvalidMessage() {
        ChatMessage message = new ChatMessage();
        message.setSender("User");
        message.setContent("");

        assertThrows(InvalidMessageException.class, () -> messageController.sendMessage(message));
    }

    /**
     * Tests the handling of user join notifications.
     */
    @Test
    void testAddUser() {
        ChatMessage message = new ChatMessage();
        message.setSender("User");

        ChatMessage result = messageController.addUser(message);

        assertEquals("User joined the chat!", result.getContent());
        assertEquals("User", result.getSender());
    }
}