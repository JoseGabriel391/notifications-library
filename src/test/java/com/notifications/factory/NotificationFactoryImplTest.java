package com.notifications.factory;

import com.notifications.api.contract.NotificationSender;
import com.notifications.channel.ChannelType;
import com.notifications.config.NotificationConfiguration;
import com.notifications.provider.implementation.FirebaseProvider;
import com.notifications.provider.implementation.SendGridProvider;
import com.notifications.provider.implementation.TwilioProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class NotificationFactoryImplTest {

    @Test
    void shouldCreateEmailSender() {

        NotificationConfiguration configuration =
                new NotificationConfiguration(
                        new SendGridProvider(),
                        new TwilioProvider(),
                        new FirebaseProvider(),
                        null,
                        null,
                        null
                );

        NotificationFactoryImpl factory =
                new NotificationFactoryImpl(
                        configuration
                );

        NotificationSender sender =
                factory.create(
                        ChannelType.EMAIL
                );

        assertNotNull(sender);
    }
}