package com.notifications.factory;

import com.notifications.api.contract.NotificationSender;
import com.notifications.api.model.Notification;
import com.notifications.api.model.NotificationRequest;
import com.notifications.api.model.NotificationResult;
import com.notifications.channel.ChannelType;

public class NotificationService {

    private final NotificationFactory factory;

    public NotificationService(NotificationFactory factory) {
        this.factory = factory;
    }

    public NotificationResult send(NotificationRequest request) {

        NotificationSender sender = factory.create(request.getChannelType());

        return sender.send(request.getNotification());
    }
}
