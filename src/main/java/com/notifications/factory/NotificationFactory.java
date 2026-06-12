package com.notifications.factory;

import com.notifications.api.contract.NotificationSender;
import com.notifications.channel.ChannelType;

public interface NotificationFactory {

    NotificationSender create(ChannelType channelType);
}
