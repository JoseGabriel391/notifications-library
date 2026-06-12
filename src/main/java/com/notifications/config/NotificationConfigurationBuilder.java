package com.notifications.config;

import com.notifications.exception.ConfigurationException;
import com.notifications.provider.ProviderFactory;

public class NotificationConfigurationBuilder {

    private ProviderType emailProviderType;
    private ProviderType smsProviderType;
    private ProviderType pushProviderType;

    public NotificationConfigurationBuilder emailProvider(
            ProviderType providerType) {

        this.emailProviderType = providerType;
        return this;
    }

    public NotificationConfigurationBuilder smsProvider(
            ProviderType providerType) {

        this.smsProviderType = providerType;
        return this;
    }

    public NotificationConfigurationBuilder pushProvider(
            ProviderType providerType) {

        this.pushProviderType = providerType;
        return this;
    }

    public NotificationConfiguration build() {

        if (emailProviderType == null) {
            throw new ConfigurationException(
                    "Email provider is required"
            );
        }

        if (smsProviderType == null) {
            throw new ConfigurationException(
                    "SMS provider is required"
            );
        }

        if (pushProviderType == null) {
            throw new ConfigurationException(
                    "Push provider is required"
            );
        }

        ProviderFactory providerFactory = new ProviderFactory();
        NotificationConfiguration configuration = new NotificationConfiguration();

        configuration.setEmailProviderType(emailProviderType);
        configuration.setSmsProviderType(smsProviderType);
        configuration.setPushProviderType(pushProviderType);

        configuration.setEmailProvider(
                providerFactory.create(
                        emailProviderType
                )
        );

        configuration.setSmsProvider(
                providerFactory.create(
                        smsProviderType
                )
        );

        configuration.setPushProvider(
                providerFactory.create(
                        pushProviderType
                )
        );

        return configuration;
    }
}
