import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        System.out.print("Выберите машину:" +
                "\n1 Внедорожник" +
                "\n2 Хетчбек\n ~~~ ");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch (choice) {
            case 1: {
                Car car1 = context.getBean("JeepBean", Car.class); //создаем объект класса Jeep
                CarDealership dealer = new CarDealership(car1); //создаем объект магазина
                dealer.getInfo();
                break;
            }
            case 2:{
                Car car2 = context.getBean("HatchbackBean", Car.class);
                CarDealership dealer = new CarDealership(car2);
                dealer.getInfo();
                break;
            }
        }
        context.close();


    }
}
