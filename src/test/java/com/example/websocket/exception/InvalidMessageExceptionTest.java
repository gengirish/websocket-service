package com.example.websocket.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for {@link InvalidMessageException}.
 * Verifies the custom exception for invalid messages.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
class InvalidMessageExceptionTest {

    /**
     * Tests the constructor and message of the custom exception.
     */
    @Test
    void testExceptionMessage() {
        String errorMessage = "Test error message";
        InvalidMessageException exception = new InvalidMessageException(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }
}