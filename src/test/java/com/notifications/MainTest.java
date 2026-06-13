package com.notifications;

import com.notifications.example.NotificationExamples;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class MainTest {

    @Test
    void shouldRunExampleWithoutErrors() {

        assertDoesNotThrow(
                () -> NotificationExamples.main(new String[]{})
        );
    }
}