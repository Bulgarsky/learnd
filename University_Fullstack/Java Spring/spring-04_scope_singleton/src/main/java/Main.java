import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;
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
                //scope: singleton (созд Один и тот же обьект)
                Dealership dealer1 = context.getBean("cardealer_sale_jeep", Dealership.class);
                Dealership dealer2 = context.getBean("cardealer_sale_jeep", Dealership.class);
                System.out.println(dealer1); //Dealership@7193666c
                System.out.println(dealer2); //Dealership@7193666c
                System.out.println(dealer1 == dealer2); //true - один и тот же обьект
                System.out.println(dealer1.getCity()); //Ufa
                System.out.println(dealer2.getCity()); //Ufa
                dealer1.setCity("NY");
                System.out.println(dealer1.getCity()); //NY
                System.out.println(dealer2.getCity());//NY
                break;
            }
            case 2:{
                Dealership dealer3 = context.getBean("cardealer_sale_hatchback", Dealership.class);
                Dealership dealer4 = context.getBean("cardealer_sale_hatchback", Dealership.class);
                System.out.println(dealer3); //Dealership@2f7298b
                System.out.println(dealer4);//Dealership@2f7298b
                System.out.println(dealer3.getCity()); //Saint Petersburg
                System.out.println(dealer4.getCity()); //Saint Petersburg
                System.out.println(dealer3 == dealer4);  //true - один и тот же обьект
                dealer3.setCity("PITER");
                System.out.println(dealer3.getCity()); //PITER
                System.out.println(dealer4.getCity());//PITER
                break;
            }
        }
        context.close();
    }
}
