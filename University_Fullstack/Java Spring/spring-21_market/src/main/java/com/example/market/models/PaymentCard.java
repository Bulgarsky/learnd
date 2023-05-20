package com.example.market.models;

public class PaymentCard {
    //valid 16 зашифровать, выводить только 4 последние цифры
    String cardNo;

    //valid две цифры
    String year;
    String month;

    //valid три цифры, зашифровать
    int cvc;
}
