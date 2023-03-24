import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        market();
    }

    public static void market() {
        ArrayList<User> usersList = new ArrayList<>();
        usersList.add(new User("admin", "admin", true)); //admin
        usersList.add(new User("user", "user")); //visitor

        ArrayList<Product> productsList = new ArrayList<>();
        productsList.add(new Product("AAA111", "Samsung TV 43", "34499", "Телевизор Самсунг 43 дюйма со SmartTV"));
        productsList.add(new Product("BBB222", "Dexp 32 QF321K", "15999", "Монитор с разрешением 2К"));
        productsList.add(new Product("CCC333", "Kitfort kt-220", "7650", "Рожковая кофемашина 3 режима"));
        productsList.add(new Product("DDD444", "A4tech KB-755bk", "1399", "Игровая клавиатура"));

        boolean checkStatus;
        String addProductNO = null;
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Магазин\n1 регистрация пользователя\n2 вход в ЛК\n3 выход из системы\n ~~~");
            int marketMenu = in.nextInt();
            in.nextLine();
            switch (marketMenu) {
                case 1: //регистрация
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
                case 2: ////вход в лк
                    System.out.println("Вход в ЛК");
                    System.out.print("Введите свой логин: ");
                    String loginAuth = in.nextLine();
                    System.out.print("Введите свой пароль: ");
                    String passwordAuth = in.nextLine();
                    //User userAuth = new User(loginAuth, passwordAuth);
                    //аутентификация
                    if (!authentication(loginAuth, passwordAuth, usersList)) { //false
                        System.out.println("[Введеные не корректные логин или пароль!]\n");
                    } else { //true
                        boolean onlineStatus = true;
                        while (onlineStatus) {
                            //admin
                            if (checkAdminRights(loginAuth, usersList)) { //true
                                System.out.print("\n" +
                                        "Личный кабинет (Администратор):\n" +
                                        "1 Просмотр товаров\n" +
                                        "2 Поиск по артикулу\n" +
                                        "3 Удалить товар\n" +
                                        "4 Добавить товар\n" +
                                        "5 Вывести всех пользователей\n" +
                                        "6 Повысить пользователя до администратора\n" +
                                        "7 Выйти из аккаунта\n ~~~ ");
                                int adminMenu = in.nextInt();
                                in.nextLine(); // каретка
                                switch (adminMenu) {
                                    case 1: //список товаров
                                        System.out.println("\nСписок всех товаров:");
                                        getProductsList(productsList);
                                        break;
                                    case 2: //поиск по артикулу с проверками
                                        do {
                                            checkStatus = true;
                                            System.out.print("Введите артикул для поиска: ");
                                            String article = in.next();
                                            if (!checkProductNO(article)) {
                                                System.out.println("Введите артикул согласно маске [AAA222]!");
                                                checkStatus = true;
                                            } else if (findProduct(article, productsList)) {
                                                checkStatus = false;
                                            } else {
                                                System.out.println("Артикул не найден в базе");
                                                checkStatus = false; //true - зациклить до успешного поиска
                                            }
                                        } while (checkStatus);
                                        break;
                                    case 3: // удалить товар
                                        System.out.println("\n[Меню удаления товара]");
                                        getProductsList(productsList);
                                        System.out.print("Введите индекс товара по списку для удаления: ");
                                        int index = in.nextInt();

                                        System.out.print("Удалить товар?\n[1] Удалить\n[2] Отмена\n~~~~ ");
                                        int deleteAccept = in.nextInt();
                                        switch (deleteAccept) {
                                            case 1: //да
                                                productsList.remove(index);
                                                System.out.println("[Товар удален!]\n");
                                                break;
                                            case 2: // нет
                                                System.out.println("[Удаление отменено]\n");
                                                break;
                                        }
                                        break;
                                    case 4: // добавить товар
                                        System.out.println("\n[добавить товар]");
                                        do {//цикл проверки артикула
                                            checkStatus = false;
                                            System.out.print("Введите артикул: ");
                                            addProductNO = in.nextLine();
                                            if (!checkProductNO(addProductNO)) {
                                                System.out.println("Введите артикул согласно маске [AAA222]!");
                                                checkStatus = true;
                                            }
                                            if (findProduct(addProductNO, productsList)) {
                                                System.out.println("[Такой артикул существует]");
                                                checkStatus = true;
                                            }
                                        } while (checkStatus);
                                        System.out.print("Введите наименование: ");
                                        String addItem = in.nextLine();
                                        System.out.print("Введите цену: ");
                                        String addPrice = in.nextLine();
                                        System.out.print("Введите описание: ");
                                        String addDescription = in.nextLine();

                                        System.out.print("Добавить товар?\n[1] Добавить\n[2] Отмена\n~~~~ ");
                                        int addAccept = in.nextInt();
                                        switch (addAccept) {
                                            case 1: //да
                                                productsList.add(new Product(addProductNO, addItem, addPrice, addDescription));
                                                System.out.println("[Товар добавлен!]\n");
                                                break;
                                            case 2: // нет
                                                System.out.println("[Добавление товара отменено]");
                                                break;
                                        }
                                        //добавить товар: конец
                                        break;
                                    case 5: // Вывести всем пользователей
                                        printUserList(usersList);
                                        break;
                                    case 6: // Повысить пользователя до администратора
                                        System.out.println("[Управление правами пользователей]");
                                        printUserList(usersList);
                                        System.out.print("Введите индекс пользователя для изменения роли: ");
                                        int userIndex = in.nextInt();
                                        System.out.print("Выдать права администратора?\n[1] Да\n[2] Отмена\n~~~~ ");
                                        int rightsAccept = in.nextInt();
                                        switch (rightsAccept) {
                                            case 1: //да
                                                usersList.get(userIndex).setAdminRights(true);
                                                System.out.println("[Пользователь "+usersList.get(userIndex).getLogin()+" теперь администратор!]\n");
                                                break;
                                            case 2: // нет
                                                System.out.println("[Удаление отменено]\n");
                                                break;
                                        }
                                        break;
                                    case 7: //выход в предыдущий свитч
                                        System.out.println("\n[Вы вышли из своего аккаунта]\n");
                                        onlineStatus = false;
                                        break; //false
                                    default:
                                        System.out.println("Используйте нумерацию меню 1-7\n");
                                } //конец adminMenu

                                //onlineStatus = false;
                            } else { //false -> visitor
                                System.out.println("\nЛичный кабинет (Посетитель):\n1 Просмотр товаров\n2 Поиск по артикулу \n3 Выйти из аккаунта");
                                System.out.print("---> ");
                                int userMenu = in.nextInt();
                                switch (userMenu) { // ЛК  user
                                    case 1: //список товаров
                                        System.out.println("\nСписок всех товаров:");
                                        getProductsList(productsList);
                                        break;
                                    case 2: //поиск по артикулу с проверками
                                        do {
                                            checkStatus = true;
                                            System.out.print("Введите артикул для поиска: ");
                                            String article = in.next();
                                            if (!checkProductNO(article)) {
                                                System.out.println("[Введите артикул согласно маске AAA222!]\n");
                                                checkStatus = true;
                                            } else if (findProduct(article, productsList)) {
                                                checkStatus = false;
                                            } else {
                                                System.out.println("[Артикул не найден в базе!]");
                                                checkStatus = false; //true - зациклить до успешного поиска
                                            }
                                        } while (checkStatus);
                                        break;
                                    case 3: //выход в предыдущий свитч
                                        System.out.println("\n[Вы вышли из своего аккаунта]\n");
                                        onlineStatus = false;
                                        break; //false
                                    default:
                                        System.out.println("[Используйте нумерацию меню 1-3]\n");
                                }//конец userMenu}
                            }
                        } //конец цикла для аккаунта
                    } //аутентификация: конец else
                    break;
                case 3: //остановка программы
                    //выход
                    System.out.println("[Вы вышли из магазина]\n");
                    return;
                default:
                    System.out.println("[Используйте нумерацию меню 1-3]\n");
            } //конец marketMenu
        } //конец while
    }// market() end

    // ПОЛЬЗОВАТЕЛИ
    //authentication
    static boolean authentication(String login, String password, ArrayList<User> usersList) {
        for (User user : usersList) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                System.out.println("[Вы вошли в аккаунт [" + user.getLogin() + "]");
                return true;
            }
        }
        return false;
    }

    //проверка: права админа
    static boolean checkAdminRights(String loginAuth, ArrayList<User> usersList) {
        for (User user : usersList) {
            if (user.getLogin().contains(loginAuth) && user.isAdminRights()) {
                return true;
            }
        }
        return false;
    }

    //поиск пользователя
    static boolean findLogin(String login, ArrayList<User> usersList) {
        for (User user : usersList) {
            if (user.getLogin().contains(login)) {
                System.out.println("аккаунт [" + user.getLogin() + "] уже существует!\n");
                return true;
            }
        }
        return false;
    }

    //список всех пользователей
    static void printUserList(ArrayList<User> usersList) {
        for (User item : usersList) {
            System.out.println("[" + usersList.indexOf(item) + "] " + item.toString());
        }
        //return true;
    }

    //ТОВАРЫ
    //список товаров
    static void getProductsList(ArrayList<Product> productsList) {
        for (Product item : productsList) {
            System.out.println("[" + productsList.indexOf(item) + "] " + item.toString());
        }
        //return  true;
    }

    //поиск товара по артикулу
    static boolean findProduct(String article, ArrayList<Product> productsList) {
        for (Product item : productsList) {
            if (item.getProductNO().equals(article)) {
                System.out.println("[" + productsList.indexOf(item) + "] " + item);
                return true;
            }
        }
        //System.out.println("Артикул не найден в базе");
        return false;
    }

    // проверка: маска ввода артикула
    static boolean checkProductNO(String productNO) {
        return productNO.matches("[A-ZА-Я]{3}\\d{3}");
    }


//end
}
