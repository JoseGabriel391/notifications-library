package com.notifications.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class PushNotification extends Notification {

    private String push;
    private String title;
}
