package com.example.websocket.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for {@link ChatMessage}.
 * Verifies the getters and setters for the chat message model.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
class ChatMessageTest {

    /**
     * Tests the getters and setters for the chat message model.
     */
    @Test
    void testGettersAndSetters() {
        ChatMessage message = new ChatMessage();
        message.setSender("User");
        message.setContent("Hello, World!");

        assertEquals("User", message.getSender());
        assertEquals("Hello, World!", message.getContent());
    }
}