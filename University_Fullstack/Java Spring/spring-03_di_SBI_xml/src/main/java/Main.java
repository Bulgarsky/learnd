import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContextSetter.xml");

        System.out.print("Выберите машину:" +
                "\n1 Внедорожник" +
                "\n2 Хетчбек\n ~~~ ");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch (choice) {
            case 1: {
                //setter based injection + default constructor
                Dealership dealer1 = context.getBean("dealer_sale_jeep", Dealership.class);
                dealer1.getInfo();
                break;
            }
            case 2:{
                Dealership dealer2 = context.getBean("dealer_sale_hatchback", Dealership.class);
                dealer2.getInfo();
                break;
            }
        }
        context.close();

    }
}
