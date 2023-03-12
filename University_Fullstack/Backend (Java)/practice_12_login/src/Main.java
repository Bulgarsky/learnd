import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        auth();
    }
    public static void auth() {
        Scanner in = new Scanner(System.in);
        ArrayList<User> users = new ArrayList <>();
        while (true) {
            System.out.println("Личный кабинет\n1 регистрация пользователя\n2 вход в ЛК\n3 выход из системы");
            int inputMenu = in.nextInt();
            in.nextLine();
            switch (inputMenu) {
                case 1:
                    System.out.println("Регистрация пользователя:");
                    System.out.print("введите логин: ");
                    String login = in.nextLine();
                    System.out.print("введите пароль: ");
                    String password = in.nextLine();

                    if (findLogin(login, users)) { //true
                        break;
                    } else { //false
                        users.add(new User(login, password));
                        System.out.println("Пользователь добавлен\n ");
                    }
                    break;
                case 2:
                    System.out.print("\nвведите свой логин: ");
                    String loginAuth = in.nextLine();
                    System.out.print("введите свой пароль: ");
                    String passwordAuth = in.nextLine();
                    User user = new User(loginAuth, passwordAuth);
                    if (!findUser(loginAuth, passwordAuth, users)){
                        System.out.println("Данные для учетной записи не корректны\n");
                    }
                    break;
                case 3:
                    System.out.println("Сеанс завершен");
                    return;
            }
        }
    }
    //findUser
    static boolean findUser(String login, String password, ArrayList<User> users) {
        for (User user:users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                System.out.println("Вы авторизованы\n");
                return true;
            }
        }
        return  false;
    }
    static boolean findLogin(String login, ArrayList<User> users) {
        for (User user:users) {
            if (user.getLogin().contains(login)) {
                System.out.println("Данный аккаунт уже существует\n");
                return true;
            }
        }
        return  false;
    }

}
