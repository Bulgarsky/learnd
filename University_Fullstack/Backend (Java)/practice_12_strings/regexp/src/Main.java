import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("regexp");
        System.out.print("введи сособщение согласно маске ввода: ");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.matches("[A-Z]{2}\\d{4}")) {
            System.out.println("correct");
        } else {
            System.out.println("incorrect");
        }

    }
}