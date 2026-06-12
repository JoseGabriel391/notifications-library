package com.notifications.channel.implementation;

import com.notifications.api.contract.NotificationSender;
import com.notifications.api.model.Notification;
import com.notifications.api.model.NotificationResult;
import com.notifications.exception.NotificationSendException;
import com.notifications.provider.contract.NotificationProvider;
import com.notifications.validation.NotificationValidator;

public class EmailSender implements NotificationSender {

    private final NotificationProvider provider;

    private final NotificationValidator validator = new NotificationValidator();

    public EmailSender(NotificationProvider provider){
        this.provider = provider;
    }

    @Override
    public NotificationResult send(Notification notification){

        validator.validate(notification);

        try {

            return provider.send(notification);

        } catch (Exception e) {

            throw new NotificationSendException(
                    "Failed to send email: "
                            + e.getMessage()
            );
        }
    }
}
