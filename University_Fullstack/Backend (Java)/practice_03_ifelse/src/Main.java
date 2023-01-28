import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int result;
        System.out.println("Even or Odd ?");
        System.out.print("Enter INT (введите целое число): ");
        Scanner in = new Scanner(System.in);
        var userInt = in.nextInt();
        result = userInt % 2;

        if (result > 0) {
            System.out.printf("INT is Odd (Введенное число %d - не четное)!", userInt);
        }
            else {
            System.out.printf("INT is Even (Введенное число %d - четное)!", userInt);
            }
    }
}