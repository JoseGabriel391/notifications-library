package com.notifications.validation;

public class PushValidator {

    public boolean isValid(String title) {

        if (title == null) {
            return false;
        }

        title = title.trim();

        if (title.isEmpty()) {
            return false;
        }

        return true;
    }
}
