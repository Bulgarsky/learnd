import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        auth();
    }

    public static void auth() {
        System.out.println("[АЭРОПОРТ.ЕХЕ]");
        Scanner in = new Scanner(System.in);
        ArrayList<Flights> flightsList = new ArrayList<>();
        String flightNO = null;
        boolean status;
        while (true) {
            System.out.print("\n[ПАНЕЛЬ УПРАВЛЕНИЯ]\n[1] Добавить рейс\n[2] Печать всех рейсов\n[3] Выход из системы\n ~~ ");
            int inputMenu = in.nextInt();
            in.nextLine(); // каретка
            switch (inputMenu) {
                case 1:
                    System.out.println("\n[ДОБАВЛЕНИЕ НОВОГО РЕЙСА]");
                    //цикл
                    do {
                        status = false; //переключение статуса  на false
                        System.out.print("Введите номер рейса: ");
                        flightNO = in.nextLine();
                        if (!checkFlightNO(flightNO)) {
                            System.out.println("[Введите рейс согласно маске (AZ0369)]");
                            status = true; //переключение статуса  на true и повтор цикла Do
                        }
                        if (findFlight(flightNO, flightsList)) {
                            System.out.println("[Такой рейс существует!]");
                            status = true; //переключение статуса  на true и повтор цикла Do
                        }
                    } while (status); //выполнять пока статус true

                    System.out.print("Введите аэропорт: ");
                    String airportName = in.nextLine();
                    System.out.print("Введите перевозщика: ");
                    String carrierName = in.nextLine();
                    System.out.print("Введите пункт назначения: ");
                    String destination = in.nextLine();
                    String departureTime;
                    //цикл для проверки маски времени
                    do {
                        status = false; //переключение статуса  на false
                        System.out.print("Введите время отбытия: ");
                        departureTime = in.nextLine();
                        //проверка маски времени через метод checkTime
                        if (!checkTime(departureTime)) {
                            status = true; //переключение статуса  на true и повтор цикла Do
                            System.out.println("[Введите время согласно маске ХХ:ХХ]");
                        }
                    } while (status); //выполнять пока статус true

                    System.out.print("Введите цену билета: ");
                    String ticketPrice = in.nextLine();
                    System.out.print("Добавить рейс?\n[1] Добавить\n[2] Отменить\n~~~~ ");
                    int Accept = in.nextInt();
                    switch (Accept) {
                        case 1:
                            flightsList.add(new Flights(flightNO, airportName, carrierName, destination, departureTime, ticketPrice));
                            System.out.println("[Рейс добавлен!]\n");
                            break;
                        case 2:
                            System.out.println("[Данные сброшены]");
                            break;
                    }
                    break;
                case 2:
                    for (Flights item : flightsList) {
                        item.printFlightDetails();
                        System.out.println(item);
                    }
                    break;
                case 3:
                    System.out.println("[СЕАНС ЗАВЕРШЕН. ЗАКРЫТИЕ СМЕНЫ]");
                    return;
            }
        }
    }

    //methods
    static boolean findFlight(String FlightNO, ArrayList<Flights> flightsList) {
        for (Flights Flights : flightsList) {
            if (Flights.getFlightNO().equals(FlightNO)) {
                return true;
            }
        }
        return false;
    }

    static boolean checkFlightNO(String FlightNO) {
            if (FlightNO.matches("[A-ZА-Я]{2}\\d{4}")) {
                return true;
            }
        return false;
    }

    static boolean checkTime(String departureTime) {
        if (departureTime.matches("[0-2]\\d:[0-5]\\d")) {
            return true;
        }
        return false;
    }

}
