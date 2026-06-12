package com.notifications.config;

import com.notifications.provider.contract.NotificationProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationConfiguration {

    private NotificationProvider emailProvider;
    private NotificationProvider smsProvider;
    private NotificationProvider pushProvider;
    private ProviderType emailProviderType;
    private ProviderType smsProviderType;
    private ProviderType pushProviderType;
}
