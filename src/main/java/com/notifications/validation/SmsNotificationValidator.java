package com.notifications.validation;

import com.notifications.api.model.SmsNotification;
import com.notifications.exception.ValidationException;

public class SmsNotificationValidator {

    public void validate(
            SmsNotification notification) {

        if (notification == null) {
            throw new ValidationException(
                    "SMS notification cannot be null"
            );
        }

        if (notification.getRecipient() == null
                || notification.getRecipient().isBlank()) {

            throw new ValidationException(
                    "SMS recipient is required"
            );
        }

        if (notification.getMessage() == null
                || notification.getMessage().isBlank()) {

            throw new ValidationException(
                    "SMS message is required"
            );
        }
    }
}
