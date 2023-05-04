package com.example.market.enumm;

public enum Role {
    ROLE_USER("Покупатель"),
    ROLE_ADMIN("Администратор"),
    ROLE_SELLER("Продавец");

    private final String displayValue;

    Role(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}

