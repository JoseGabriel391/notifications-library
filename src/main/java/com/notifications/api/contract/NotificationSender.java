package com.notifications.api.contract;

import com.notifications.api.model.Notification;
import com.notifications.api.model.NotificationResult;

public interface NotificationSender {
    NotificationResult send(Notification notification);

}
