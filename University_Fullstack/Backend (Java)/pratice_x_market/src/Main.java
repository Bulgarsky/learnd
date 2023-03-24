import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        market();
    }
    public static void market() {
        ArrayList<User> usersList = new ArrayList <>();
        usersList.add(new User("admin", "admin"));
        ArrayList<Product> productsList = new ArrayList<>();
        productsList.add(new Product("AAA111", "Samsung TV 43", "34499", "Телевизор Самсунг 43 дюйма со SmartTV"));
        productsList.add(new Product("BBB222", "Dexp 32 QF321K", "15999", "Монитор с разрешением 2К"));
        productsList.add(new Product("CCC333", "Kitfort kt-220", "7650", "Рожковая кофемашина 3 режима"));
        productsList.add(new Product("DDD444", "A4tech KB-755bk", "1399", "Игровая клавиатура"));

        boolean searchStatus;
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Магазин\n1 регистрация пользователя\n2 вход в ЛК\n3 выход из системы");
            System.out.print("---> ");
            int marketMenu = in.nextInt();
            in.nextLine();
            switch (marketMenu) {
                case 1:
                    //регистрация
                    System.out.println("Регистрация пользователя:");
                    System.out.print("Введите логин: ");
                    String login = in.nextLine();
                    System.out.print("Введите пароль: ");
                    String password = in.nextLine();
                    //поиск акаунта
                    if (findLogin(login, usersList)) { //true
                        break;
                    } else { //false
                        usersList.add(new User(login, password));
                        System.out.println("[Пользователь добавлен!]\n ");
                    }
                    break;
                case 2:
                    //вход в лк
                    System.out.println("Вход в ЛК");
                    System.out.print("Введите свой логин: ");
                    String loginAuth = in.nextLine();
                    System.out.print("Введите свой пароль: ");
                    String passwordAuth = in.nextLine();
                    User userAuth = new User(loginAuth, passwordAuth);
                    //аутентификация
                    if (!authentication(loginAuth, passwordAuth, usersList)){ //false
                        System.out.println("[Введеные не корректные лгин или пароль!]\n");
                    }else { //true
                        boolean onlineStatus = true;
                        while (onlineStatus) {
                        System.out.println("\nЛичный кабинет:\n1 Просмотр товаров\n2 Поиск по артикулу \n3 Выйти из аккаунта");
                        System.out.print("---> ");
                        int accountMenu = in.nextInt();
                        switch (accountMenu) {
                            case 1:
                                System.out.println("\nСписок всех товаров:");
                                getProductsList(productsList);
                                break;
                            case 2:
                                do {
                                    searchStatus = false;
                                    System.out.print("Введите артикул для поиска: ");
                                    String article = in.next();
                                    if (!checkProductNO(article)) {
                                        System.out.println("Введите артикул согласно маске [AAA222]! Р");
                                        searchStatus = true;
                                    } else
                                    if (findProduct(article, productsList)) {
                                        searchStatus = false;
                                    }
                                } while (searchStatus);

                                break;
                            case 3:
                                System.out.println("\n[Вы вышли из своего аккаунта]\n");
                                onlineStatus = false;
                                break; //false
                            default:
                                System.out.println("Используйте нумерацию меню 1-3\n");
                            }//конец accountMenu
                        } //конец цикла для аккаунт
                    } //конец else
                    break;
                case 3:
                    //выход
                    System.out.println("[Вы вышли из магазина]\n");
                    return;
                default:
                    System.out.println("Используйте нумерацию меню 1-3\n");
            } //конец marketMenu
        } //конец while
    }// market() end

    //authentication
    static boolean authentication(String login, String password, ArrayList<User> usersList) {
        for (User user:usersList) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                System.out.println("[Вы вошли в аккаунт ["+user.getLogin()+"]\n");
                return true;
            }
        }
        return  false;
    }

    //поиск пользователя
    static boolean findLogin(String login, ArrayList<User> usersList) {
        for (User user:usersList) {
            if (user.getLogin().contains(login)) {
                System.out.println("аккаунт ["+user.getLogin()+"] уже существует!\n");
                return true;
            }
        }
        return  false;
    }

    //список товаров
    static boolean getProductsList (ArrayList<Product> productsList) {
        for (Product item: productsList) {
            System.out.println("["+productsList.indexOf(item)+"] "+ item.toString());
            }
        return  true;
    }

    //поиск товара по артикулу
    static boolean findProduct (String article,ArrayList<Product> productsList) {
        for (Product item: productsList) {
            if (item.getProductNO().equals(article)) {
            System.out.println("["+productsList.indexOf(item)+"] "+ item.toString());
            return true;
            }
        }
        return  false;
    }
    // проверка на идентичность товара
    static boolean checkProductNO(String productNO) {
        if (productNO.matches("[A-ZА-Я]{3}\\d{3}")) {
            return true;
        }
        return false;
    }
}
