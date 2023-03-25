import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        market();
    }

    public static void market() {
        ArrayList<User> usersList = new ArrayList<>();
        usersList.add(new User("admin", "admin", true, "admin@market.info", "Market", "Super", "Admin"));
        usersList.add(new User("user", "user", "user@market.info", "Local", "Test", "Account"));

        ArrayList<Product> productsList = new ArrayList<>();
        productsList.add(new Product("AAA111", "Samsung TV 43", "34499", "Телевизор Самсунг 43 дюйма со SmartTV"));
        productsList.add(new Product("BBB222", "Dexp 32 QF321K", "15999", "Монитор с разрешением 2К"));
        productsList.add(new Product("CCC333", "Kitfort kt-220", "7650", "Рожковая кофемашина 3 режима"));
        productsList.add(new Product("DDD444", "A4tech KB-755bk", "1399", "Игровая клавиатура"));

        ArrayList<Product> orderBasket = new ArrayList<>();
        boolean checkStatus;
        String addProductNO = null;
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("""
                    
                    [Магазин]
                    1 регистрация пользователя
                    2 вход в ЛК
                    3 выход из системы
                    ~~~ \s""");
            int marketMenu = in.nextInt();
            in.nextLine();
            switch (marketMenu) {
                case 1: //регистрация
                    System.out.println("[Регистрация пользователя]");
                    String login;
                    do {
                        checkStatus = false;
                        System.out.print("Введите логин: ");
                        login = in.nextLine();
                        if (findLogin(login, usersList)) { //true
                            checkStatus = true;
                        }
                    }while (checkStatus);
                    System.out.print("Введите пароль: ");
                    String password = in.nextLine();
                    String email;
                    do {
                        checkStatus = false;
                        System.out.print("Введите почту: ");
                        email= in.nextLine();
                        if (checkEmail(email)) {
                            System.out.println("[Введите почту согласно маске: email@domain.tld ]");
                            checkStatus = true;
                        }
                    } while (checkStatus);

                    System.out.print("Введите вашу фамилию: ");
                    String lastName = in.nextLine();
                    System.out.print("Введите ваше имя: ");
                    String firstName = in.nextLine();
                    System.out.print("Введите ваше отчество: ");
                    String middleName = in.nextLine();
                    usersList.add(new User(login, password, email, lastName, firstName, middleName));
                    System.out.println("[Пользователь добавлен!]");
                    break;
                case 2:
                    System.out.println("\n[Вход в ЛК]");
                    System.out.print("Введите свой логин или почту: ");
                    String accountAuth = in.nextLine();
                    System.out.print("Введите свой пароль: ");
                    String passwordAuth = in.nextLine();
                    //аутентификация (!authentication(loginAuth, passwordAuth, usersList)
                    if (!authentication(accountAuth, passwordAuth, usersList)) { //false
                        System.out.println("[Введены не корректные логин/email или пароль!]");
                    } else { //true
                        boolean onlineStatus = true;
                        while (onlineStatus) {
                            //admin
                            if (checkAdminRights(accountAuth, usersList)) { //true
                                System.out.print("""
                                        
                                        Личный кабинет (Администратор):
                                        1 Просмотр всех товаров в магазине
                                        2 Поиск по артикулу
                                        3 Удалить товар из базы
                                        4 Добавить товар в базу

                                        5 Вывести всех пользователей
                                        6 Повысить пользователя до администратора
                                        7 Выйти из аккаунта
                                         ~~~ \s""");
                                int adminMenu = in.nextInt();
                                in.nextLine(); // каретка
                                switch (adminMenu) {
                                    case 1:
                                        System.out.println("Список всех товаров:");
                                        getProductsList(productsList);
                                        break;
                                    case 2:
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
                                    case 3:
                                        System.out.println("\n[Меню удаления товара]");
                                        getProductsList(productsList);
                                        System.out.print("Введите индекс товара по списку для удаления: ");
                                        int index = in.nextInt();

                                        System.out.print("Удалить товар?\n[1] Да\n[2] Нет\n~~~~ ");
                                        int removeProduct = in.nextInt();
                                        switch (removeProduct) {
                                            case 1:
                                                productsList.remove(index);
                                                System.out.println("[Товар удален!]");
                                                break;
                                            case 2:
                                                System.out.println("[Удаление отменено]");
                                                break;
                                        }
                                        break;
                                    case 4:
                                        System.out.println("\n[добавить товар]");
                                        do {
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
                                        int addProduct = in.nextInt();
                                        switch (addProduct) {
                                            case 1:
                                                productsList.add(new Product(addProductNO, addItem, addPrice, addDescription));
                                                System.out.println("[Товар добавлен в базу!]");
                                                break;
                                            case 2:
                                                System.out.println("[Добавление товара в базу отменено]");
                                                break;
                                        }
                                        break;
                                    case 5:
                                        printUserList(usersList);
                                        break;
                                    case 6:
                                        System.out.println("[Управление правами пользователей]");
                                        printUserList(usersList);
                                        System.out.print("Введите индекс пользователя для изменения роли: ");
                                        int userIndex = in.nextInt();
                                        System.out.print("[Авторизация прав]\n[1] Назначить администратором\n[2] Назначить пользователем\n~~~~ ");
                                        int rightsAccept = in.nextInt();
                                        switch (rightsAccept) {
                                            case 1:
                                                usersList.get(userIndex).setAdminRights(true);
                                                System.out.println("[Пользователь ["+usersList.get(userIndex).getLogin()+"] теперь администратор!]");
                                                break;
                                            case 2:
                                                usersList.get(userIndex).setAdminRights(false);
                                                System.out.println("[Пользователь ["+usersList.get(userIndex).getLogin()+"] теперь обычный пользователь!]");
                                                break;
                                        }
                                        break;
                                    case 7: //выход в предыдущий свитч
                                        System.out.println("[Вы вышли из своего аккаунта]");
                                        onlineStatus = false;
                                        break; //false
                                    default:
                                        System.out.println("Используйте нумерацию меню 1-7\n");
                                }
                            } else {
                                System.out.print("""

                                        Личный кабинет (Посетитель):
                                        1 Просмотр всех товаров в магазине
                                        2 Поиск по артикулу
                                        3 Добавить товары в корзину
                                        4 Удалить товары из корзины
                                        5 Корзина
                                        6 Выйти из аккаунта
                                         ~~~~ \s""");
                                int userMenu = in.nextInt();
                                switch (userMenu) { // ЛК  user
                                    case 1:
                                        System.out.println("\n[Список всех товаров]");
                                        getProductsList(productsList);
                                        break;
                                    case 2:
                                        do {
                                            //checkStatus = true;
                                            System.out.print("Введите артикул для поиска: ");
                                            String article = in.next();
                                            if (!checkProductNO(article)) {
                                                System.out.println("[Введите артикул согласно маске AAA222!]");
                                                checkStatus = true;
                                            } else if (findProduct(article, productsList)) {
                                                checkStatus = false;
                                            } else {
                                                System.out.println("[Артикул не найден в базе!]");
                                                checkStatus = false; //true - зациклить до успешного поиска
                                            }
                                        } while (checkStatus);
                                        break;
                                    case 3: //корзина

                                        boolean addBasketStatus = false;
                                        do {
                                            System.out.println("[Список доступных товаров в магазине]");
                                            getProductsList(productsList);
                                            System.out.print("Введите индекс для добавления товара в корзину: ");
                                            int productIndex = in.nextInt();
                                            Product orderItem = productsList.get(productIndex);
                                            System.out.print("Добавить товар в корзину?\n[1] Да\n[2] Нет\n~~~~ ");
                                            int addBasket = in.nextInt();
                                            switch (addBasket) {
                                                case 1:
                                                    orderBasket.add(orderItem);
                                                    System.out.println("[Товар добавлен в корзину!]");
                                                    break;
                                                case 2:
                                                    System.out.println("[Добавление товара в корзину отменено]");
                                                    break;
                                            }
                                            System.out.print("Хотите добавить еще товар?\n 1 Да\n 2 Нет\n ~~~ ");
                                            int addRepeat = in.nextInt();
                                            switch (addRepeat) {
                                                case 1:
                                                    addBasketStatus = true;
                                                    break;
                                                case 2:
                                                    addBasketStatus = false;
                                                    break;
                                            }
                                        }while (addBasketStatus);
                                        break;
                                    case 4:
                                        boolean removeBasketStatus;
                                        do {
                                            removeBasketStatus = false;
                                            System.out.println("[Список товаров в корзине]");
                                            getBasketList(orderBasket);
                                            System.out.print("Введите индекс для удаления товара из корзины: ");
                                            int removeIndex = in.nextInt();
                                            Product orderItem = orderBasket.get(removeIndex);
                                            System.out.print("Удалить товар из корзины?\n[1] Да\n[2] Нет\n~~~~ ");
                                            int removeBasket = in.nextInt();
                                            switch (removeBasket) {
                                                case 1:
                                                    orderBasket.remove(removeIndex);
                                                    System.out.println("[Товар удален из корзины!]");
                                                    break;
                                                case 2:
                                                    System.out.println("[Удаление товара из корзины отменено]");
                                                    break;
                                            }
                                            System.out.print("Хотите удалить еще товар?\n 1 Да\n 2 Нет\n ~~~ ");
                                            int removeRepeat = in.nextInt();
                                            switch (removeRepeat) {
                                                case 1:
                                                    removeBasketStatus = true;
                                                    break;
                                                case 2:
                                                    removeBasketStatus = false;
                                                    break;
                                            }

                                        }while (removeBasketStatus);
                                        break;
                                    case 5:
                                        System.out.println("[Список товаров в корзине]");
                                        getProductsList(orderBasket);
                                        break;
                                    case 6:
                                        System.out.println("[Вы вышли из своего аккаунта]");
                                        onlineStatus = false;
                                        break;
                                    default:
                                        System.out.println("[Используйте нумерацию меню 1-6]");
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("[Вы вышли из магазина]");
                    return;
                default:
                    System.out.println("[Используйте нумерацию меню 1-3]");
            }
        }
    }

    // ПОЛЬЗОВАТЕЛИ
    //authentication
    static boolean authentication2(String login, String password, ArrayList<User> usersList) {
        for (User user : usersList) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                System.out.println("[Вы вошли в аккаунт [" + user.getLogin() + "]");
                return true;
            }
        }
        return false;
    }
    //authentication: вход по почте или логину
    static boolean authentication(String account, String password, ArrayList<User> usersList) {
        for (User user : usersList) {
            if ((user.getLogin().contains(account) && user.getPassword().equals(password))
                    || (user.getEmail().contains(account) && user.getPassword().equals(password))) {
                return true;
            }
        }
        return false;
    }

    //проверка: права админа
    static boolean checkAdminRights(String account, ArrayList<User> usersList) {
        for (User user : usersList) {
            if ((user.getLogin().contains(account) && user.isAdminRights())
                    || user.getEmail().contains(account) &&user.isAdminRights()) {
                return true;
            }
        }
        return false;
    }

    //поиск пользователя
    static boolean findLogin(String login, ArrayList<User> usersList) {
        for (User user : usersList) {
            if (user.getLogin().contains(login)) {
                System.out.println("аккаунт [" + user.getLogin() + "] уже существует. Используйте другой логин!\n");
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
    }
    static void getBasketList(ArrayList<Product> orderBasket) {
        for (Product item : orderBasket) {
            System.out.println("[" + orderBasket.indexOf(item) + "] " + item.toString());
        }
    }

    //поиск товара по артикулу
    static boolean findProduct(String productNO, ArrayList<Product> productsList) {
        for (Product item : productsList) {
            if (item.getProductNO().equals(productNO)) {
                System.out.println("[" + productsList.indexOf(item) + "] " + item);
                return true;
            }
        }
        return false;
    }

    // проверка: маска ввода артикула
    static boolean checkProductNO(String productNO) {
        return productNO.matches("[A-ZА-Я]{3}\\d{3}");
    }

    //проверка: маска ввода почта
    static boolean checkEmail (String email) {
        if (email.matches("[A-Za-z0-9]{1,10}@[A-Za-z0-9]{2,10}.[A-Za-z0-9]{2,4}")) {
            return false;
        }
        else {
            return true;
        }
    }

    //проверка: вход по почте или логину
    static boolean ckeckAccount (String accaunt, String password, ArrayList<User> usersList) {
        for (User user : usersList) {
            if ((user.getLogin().contains(accaunt) && user.getPassword().equals(password)) || (user.getEmail().contains(accaunt) && user.getPassword().equals(password))) {
                return true;
            }
        }
        return false;
    }

}
