package com.example.websocket.model;

/**
 * Represents a chat message sent over WebSocket.
 * This class contains the sender's name and the message content.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
public class ChatMessage {

    private String sender;
    private String content;

    /**
     * Gets the sender's name.
     *
     * @return the sender's name.
     */
    public String getSender() {
        return sender;
    }

    /**
     * Sets the sender's name.
     *
     * @param sender the sender's name.
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * Gets the message content.
     *
     * @return the message content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the message content.
     *
     * @param content the message content.
     */
    public void setContent(String content) {
        this.content = content;
    }
}