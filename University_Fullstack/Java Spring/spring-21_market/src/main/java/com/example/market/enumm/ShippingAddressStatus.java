package com.example.market.enumm;

public enum ShippingAddressStatus {
    DEFAULT_ADDRESS_STATUS("Адрес для доставки по умолчанию"),
    ADDRESS_STATUS("Адрес");

    private final String displayValue;

    ShippingAddressStatus(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
