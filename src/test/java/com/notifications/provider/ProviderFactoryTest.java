package com.notifications.provider;

import com.notifications.config.ProviderType;
import com.notifications.provider.contract.NotificationProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProviderFactoryTest {

    @Test
    void shouldCreateSendGridProvider() {

        ProviderFactory factory =
                new ProviderFactory();

        NotificationProvider provider =
                factory.create(
                        ProviderType.SENDGRID
                );

        assertNotNull(provider);
    }
}
