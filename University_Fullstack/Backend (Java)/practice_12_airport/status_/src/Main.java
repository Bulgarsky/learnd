import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        boolean status = true;
        Scanner in = new Scanner(System.in);


        do {
            System.out.print("ENTER A: ");
            String flightNO = in.nextLine();
            if (flightNO.matches("[A-Z]{2}\\d{4}")) {
                System.out.println("Добавлено");
                status = false;
            } else {
                System.out.println("Повторите ввод согласно шалону [AA4444]");
                status = true;
            }
        } while (status == true);


        System.out.println("exit");
    }
}