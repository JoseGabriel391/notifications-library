package com.notifications.provider.contract;

import com.notifications.api.model.Notification;
import com.notifications.api.model.NotificationResult;

public interface NotificationProvider {
    NotificationResult send(Notification notification);
}
