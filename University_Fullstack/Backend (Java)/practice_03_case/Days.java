import java.util.Scanner;

public class Days {
    public static void main(String[] args) {

        System.out.print("РУ: Введите день недели: ");
        // получить данные введенные пользователем:
        Scanner in = new Scanner(System.in);
        var userIn = in.nextLine();
        // Приведем введенную строку в нижний регистр:
        String result = userIn.toLowerCase();
        switch(result) {
            case "понедельник", "вторник", "среда", "четверг", "пятница":
                System.out.println(userIn +" - это рабочий день");
                break;
            case "суббота", "воскресенье":
                System.out.println(userIn +" - это выходной день");
                break;
            default:
                System.out.println("Ошибка! Введено: " + userIn);
        }
    }
}
