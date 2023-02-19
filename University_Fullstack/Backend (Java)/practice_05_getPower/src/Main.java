import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        System.out.println("RU. Метод. Возведение числа в степень");
        Scanner in = new Scanner(System.in);
        System.out.print("RU. Введите число: ");
        int numb = in.nextInt();
        System.out.print("RU. Введите степень: ");
        int power = in.nextInt();

        getPower(numb, power);

        System.out.println("RU. 4 в степени 10: ");
        getPower(4, 10);
    }

    static void getPower(int numb, int power) {
        long result = numb;
        for (int i=1; i < power; i++) {
            result = result * numb;
        }
        System.out.println("RU: Результат = "+ result);
    }
}