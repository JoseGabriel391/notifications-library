package com.notifications.validation;

import com.notifications.api.model.Notification;
import com.notifications.exception.ValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NotificationValidatorTest {

    @Test
    void shouldThrowExceptionWhenRecipientIsEmpty() {

        Notification notification =
                new Notification("", "Hello");

        NotificationValidator validator =
                new NotificationValidator();

        assertThrows(
                ValidationException.class,
                () -> validator.validate(notification)
        );
    }
}
