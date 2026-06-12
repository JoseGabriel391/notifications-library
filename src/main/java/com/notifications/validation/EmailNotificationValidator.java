package com.notifications.validation;

import com.notifications.api.model.EmailNotification;
import com.notifications.exception.ValidationException;

public class EmailNotificationValidator {

    public void validate(
            EmailNotification notification) {

        if (notification == null) {
            throw new ValidationException(
                    "Email notification cannot be null"
            );
        }

        if (notification.getRecipient() == null
                || notification.getRecipient().isBlank()) {

            throw new ValidationException(
                    "Email recipient is required"
            );
        }

        if (notification.getSubject() == null
                || notification.getSubject().isBlank()) {

            throw new ValidationException(
                    "Email subject is required"
            );
        }

        if (notification.getMessage() == null
                || notification.getMessage().isBlank()) {

            throw new ValidationException(
                    "Email message is required"
            );
        }
    }
}
