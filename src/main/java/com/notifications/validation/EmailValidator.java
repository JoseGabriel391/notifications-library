package com.notifications.validation;

public class EmailValidator {

    public boolean isValid(String email) {

        if (email == null) {
            return false;
        }

        if (!email.contains("@")) {
            return false;
        }

        if (!email.contains(".")) {
            return false;
        }

        return true;
    }
}
