package com.notifications.provider.implementation;

import com.notifications.api.model.Notification;
import com.notifications.api.model.NotificationResult;
import com.notifications.provider.contract.NotificationProvider;

public class FirebaseProvider implements NotificationProvider {

    @Override
    public NotificationResult send(Notification notification) {

        return new NotificationResult(
                true,
                "Notification sent using Firebase"
        );
    }
}
