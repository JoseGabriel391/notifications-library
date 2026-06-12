package com.notifications.validation;

import com.notifications.api.model.Notification;
import com.notifications.exception.ValidationException;

public class NotificationValidator {

    public void validate(Notification notification) {

        if (notification == null) {
            throw new ValidationException(
                    "Notification cannot be null"
            );
        }

        if (notification.getRecipient() == null
                || notification.getRecipient().isBlank()) {

            throw new ValidationException(
                    "Recipient is required"
            );
        }

        if (notification.getMessage() == null
                || notification.getMessage().isBlank()) {

            throw new ValidationException(
                    "Message is required"
            );
        }
    }
}
