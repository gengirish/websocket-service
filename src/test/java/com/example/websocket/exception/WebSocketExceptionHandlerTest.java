package com.example.websocket.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for {@link WebSocketExceptionHandler}.
 * Verifies the handling of WebSocket-related exceptions.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
class WebSocketExceptionHandlerTest {

    private WebSocketExceptionHandler exceptionHandler = new WebSocketExceptionHandler();

    /**
     * Tests the handling of exceptions.
     */
    @Test
    void testHandleException() {
        Exception ex = new Exception("Test error");

        String result = exceptionHandler.handleException(ex);

        assertEquals("Error: Test error", result);
    }
}