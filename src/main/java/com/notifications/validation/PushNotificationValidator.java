package com.notifications.validation;

import com.notifications.api.model.PushNotification;
import com.notifications.exception.ValidationException;

public class PushNotificationValidator {

    public void validate(
            PushNotification notification) {

        if (notification == null) {
            throw new ValidationException(
                    "Push notification cannot be null"
            );
        }

        if (notification.getRecipient() == null
                || notification.getRecipient().isBlank()) {

            throw new ValidationException(
                    "Push recipient is required"
            );
        }

        if (notification.getTitle() == null
                || notification.getTitle().isBlank()) {

            throw new ValidationException(
                    "Push title is required"
            );
        }

        if (notification.getMessage() == null
                || notification.getMessage().isBlank()) {

            throw new ValidationException(
                    "Push message is required"
            );
        }
    }
}
