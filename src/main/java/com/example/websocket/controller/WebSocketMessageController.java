package com.example.websocket.controller;

import com.example.websocket.exception.InvalidMessageException;
import com.example.websocket.model.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Handles incoming WebSocket messages and dispatches them to subscribed clients.
 * This class processes messages sent to "/app/chat.sendMessage" and "/app/chat.addUser".
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
@Controller
public class WebSocketMessageController {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketMessageController.class);

    /**
     * Handles messages sent to "/app/chat.sendMessage".
     *
     * @param message the {@link ChatMessage} sent by the client.
     * @return the {@link ChatMessage} to broadcast to all subscribers.
     * @throws InvalidMessageException if the message content is empty.
     */
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage message) throws InvalidMessageException {
        logger.info("Received message from {}: {}", message.getSender(), message.getContent());

        // Validate the message (e.g., check for empty content)
        if (message.getContent() == null || message.getContent().trim().isEmpty()) {
            logger.error("Invalid message: content is empty");
            throw new InvalidMessageException("Message content cannot be empty");
        }

        logger.info("Broadcasting message to /topic/public");
        return message;
    }

    /**
     * Handles user join notifications sent to "/app/chat.addUser".
     *
     * @param message the {@link ChatMessage} sent by the client.
     * @return the {@link ChatMessage} to broadcast to all subscribers.
     */
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(ChatMessage message) {
        logger.info("New user joined: {}", message.getSender());
        message.setContent(message.getSender() + " joined the chat!");
        return message;
    }
}