package com.notifications.provider;

import com.notifications.config.ProviderType;
import com.notifications.exception.UnsupportedProviderException;
import com.notifications.provider.contract.NotificationProvider;
import com.notifications.provider.implementation.FirebaseProvider;
import com.notifications.provider.implementation.MailgunProvider;
import com.notifications.provider.implementation.SendGridProvider;
import com.notifications.provider.implementation.TwilioProvider;

public class ProviderFactory {

    public NotificationProvider create(ProviderType providerType) {

        return switch (providerType) {

            case SENDGRID -> new SendGridProvider();

            case MAILGUN -> new MailgunProvider();

            case TWILIO -> new TwilioProvider();

            case FIREBASE -> new FirebaseProvider();

            default -> throw new UnsupportedProviderException(
                    "Provider " + providerType + " is not supported"
            );
        };
    }
}
