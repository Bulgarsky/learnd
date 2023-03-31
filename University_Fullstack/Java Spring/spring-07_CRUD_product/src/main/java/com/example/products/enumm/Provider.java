package com.example.products.enumm;

public enum Provider {
    //Agro_Prom("Agro Prom")
    agroprom("Агро Пром"),
    himtorg("Химторг"),
    bars("ООО Барс"),
    gruzvozim("Грузоперевозщик");

    private final String displayValue;
    Provider(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
