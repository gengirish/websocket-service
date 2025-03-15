package com.example.websocket.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Handles WebSocket-related exceptions globally.
 * This class sends error messages to the user who triggered the exception.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
@ControllerAdvice
public class WebSocketExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketExceptionHandler.class);

    /**
     * Handles exceptions thrown during WebSocket message processing.
     *
     * @param ex the exception that occurred.
     * @return an error message to be sent to the user.
     */
    @MessageExceptionHandler
    @SendToUser("/queue/errors")
    public String handleException(Exception ex) {
        logger.error("WebSocket error: {}", ex.getMessage(), ex);
        return "Error: " + ex.getMessage();
    }
}