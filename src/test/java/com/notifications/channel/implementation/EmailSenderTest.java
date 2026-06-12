package com.notifications.channel.implementation;

import com.notifications.api.model.Notification;
import com.notifications.api.model.NotificationResult;
import com.notifications.provider.contract.NotificationProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class EmailSenderTest {

    @Test
    void shouldSendEmailUsingProvider() {

        NotificationProvider provider =
                mock(NotificationProvider.class);

        Notification notification =
                new Notification(
                        "test@test.com",
                        "Hello"
                );

        when(provider.send(notification))
                .thenReturn(
                        new NotificationResult(
                                true,
                                "Email sent"
                        )
                );

        EmailSender sender =
                new EmailSender(provider);

        NotificationResult result =
                sender.send(notification);

        assertTrue(result.isSuccess());

        verify(provider)
                .send(notification);
    }
}
