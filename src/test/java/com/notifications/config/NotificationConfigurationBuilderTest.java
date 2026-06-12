package com.notifications.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class NotificationConfigurationBuilderTest {

    @Test
    void shouldBuildConfiguration() {

        NotificationConfiguration configuration =
                new NotificationConfigurationBuilder()
                        .emailProvider(
                                ProviderType.SENDGRID
                        )
                        .smsProvider(
                                ProviderType.TWILIO
                        )
                        .pushProvider(
                                ProviderType.FIREBASE
                        )
                        .build();

        assertNotNull(configuration);
    }
}
