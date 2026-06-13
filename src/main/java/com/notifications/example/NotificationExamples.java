package com.notifications.example;

import com.notifications.api.model.Notification;
import com.notifications.api.model.NotificationRequest;
import com.notifications.api.model.NotificationResult;
import com.notifications.channel.ChannelType;
import com.notifications.config.NotificationConfiguration;
import com.notifications.config.NotificationConfigurationBuilder;
import com.notifications.config.ProviderType;
import com.notifications.factory.NotificationFactory;
import com.notifications.factory.NotificationFactoryImpl;
import com.notifications.factory.NotificationService;

public class NotificationExamples {

    public static void main(String[] args) {

        NotificationConfiguration configuration =
                new NotificationConfigurationBuilder()
                        .emailProvider(ProviderType.SENDGRID)
                        .smsProvider(ProviderType.TWILIO)
                        .pushProvider(ProviderType.FIREBASE)
                        .build();

        NotificationFactory factory =
                new NotificationFactoryImpl(configuration);

        NotificationService notificationService =
                new NotificationService(factory);

        Notification notification =
                new Notification(
                        "user@example.com",
                        "Hello from Notifications Library"
                );

        NotificationRequest request =
                new NotificationRequest(
                        ChannelType.EMAIL,
                        notification
                );

        NotificationResult result =
                notificationService.send(request);

        System.out.println("Success: " + result.isSuccess());
        System.out.println("Message: " + result.getMessage());
    }
}