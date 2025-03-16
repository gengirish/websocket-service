package com.example.websocket;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test class for {@link WebsocketApplication}.
 * This class tests the Spring Boot application context loading, the main method execution,
 * and ensures the application starts on a random port.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebsocketApplicationTests {

    @LocalServerPort
    private int port; // Injects the random port assigned to the application

    /**
     * Tests that the application context loads successfully.
     * This test ensures that the Spring Boot application starts and the context is not null.
     *
     * @param context the application context injected by Spring Boot
     */
    @Test
    void contextLoads(ApplicationContext context) {
        assertNotNull(context, "Application context should not be null");
        System.out.println("Application is running on port: " + port); // Log the random port
    }

    /**
     * Tests the main method of the {@link WebsocketApplication} class.
     * This test ensures that the main method runs without throwing any exceptions.
     */
    @Test
    void testMainMethod() {
        // Call the main method directly
        WebsocketApplication.main(new String[]{});

        // If no exception is thrown, the test passes
    }
}