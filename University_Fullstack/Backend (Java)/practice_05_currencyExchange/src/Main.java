import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        System.out.println("RU. Метод. Перевод суммы денег в валюту. Сумма и курс вводятся с клавиатуры");
        Scanner in = new Scanner(System.in);
        System.out.print("RU. Введите сумму в рублях для перевода: ");
        int wallet = in.nextInt();
        System.out.print("RU. Введите текущий курс валюты (используйте запятую для разделения): ");
        double currencyRate = in.nextDouble();

        currencyExchange(wallet, currencyRate);

        System.out.println("RU. вызов метода и отправка аргументов 52487 и 75,8: ");
        currencyEx(52487, 75.8);
    }

    static void currencyExchange(int wallet, double currencyRate) {
        double result = wallet / currencyRate;
        System.out.printf("RU: Введенная сумма "+wallet+" по курсу "+currencyRate+" = %.2f \n", result);
    }


    static double currencyEx (int wallet, double currencyRate) {
        return wallet / currencyRate;
    }
}