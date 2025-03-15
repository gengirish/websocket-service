package com.example.websocket.exception;

/**
 * Custom exception for invalid WebSocket messages.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
public class InvalidMessageException extends Exception {

    /**
     * Constructs a new {@link InvalidMessageException} with the specified detail message.
     *
     * @param message the detail message.
     */
    public InvalidMessageException(String message) {
        super(message);
    }
}