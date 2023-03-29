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
                CarDealership carDealership = context.getBean("cardealer_sale_jeep", CarDealership.class);
                carDealership.getInfo();
                break;
            }
            case 2:{
                //constructor based injection
                CarDealership carDealership = context.getBean("cardealer_sale_hatchback", CarDealership.class);
                carDealership.getInfo();
                break;
            }
        }
        context.close();


    }
}
