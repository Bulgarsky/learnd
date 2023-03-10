import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("regexp");
        String login = "admin";
        String password = "password";

        Scanner in = new Scanner(System.in);
        System.out.print("enter login: ");
        String logIn = in.nextLine();
        System.out.print("enter password: ");
        String passIn = in.nextLine();

        if (logIn.matches(login) && passIn.matches(password)) {
            System.out.println("system: You are logged");
        } else {
            System.out.println("system: logging failure");
        }

    }
}