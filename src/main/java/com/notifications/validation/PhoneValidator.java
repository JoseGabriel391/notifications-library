package com.notifications.validation;

public class PhoneValidator {

    public boolean isValid(String phone) {

        if (phone == null) {
            return false;
        }

        phone = phone.trim();

        if (phone.isEmpty()) {
            return false;
        }

        if (phone.length() < 8) {
            return false;
        }

        return true;
    }
}
