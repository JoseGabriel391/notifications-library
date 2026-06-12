package com.notifications.factory;

import com.notifications.api.contract.NotificationSender;
import com.notifications.channel.ChannelType;
import com.notifications.channel.implementation.EmailSender;
import com.notifications.channel.implementation.PushSender;
import com.notifications.channel.implementation.SmsSender;
import com.notifications.config.NotificationConfiguration;
import com.notifications.exception.UnsupportedChannelException;

public class NotificationFactoryImpl implements NotificationFactory {

    private final NotificationConfiguration configuration;

    public NotificationFactoryImpl(NotificationConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public NotificationSender create(ChannelType channelType) {

        return switch (channelType) {

            case EMAIL -> new EmailSender(configuration.getEmailProvider());

            case SMS -> new SmsSender(configuration.getSmsProvider());

            case PUSH -> new PushSender(configuration.getPushProvider());

            default -> throw new UnsupportedChannelException(
                    "Channel " + channelType + " is not supported"
            );
        };
    }
}
