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
                //scope: prototype (созд разные объекты)
                Dealership dealer1 = context.getBean("dealer_sale_jeep", Dealership.class);
                Dealership dealer2 = context.getBean("dealer_sale_jeep", Dealership.class);
                System.out.println(dealer1); //Dealership@7fa98a66
                System.out.println(dealer2); //Dealership@15ff3e9e
                System.out.println(dealer1 == dealer2); //false - разные объекты
                System.out.println(dealer1.getCity()); //Ufa
                System.out.println(dealer2.getCity()); //Ufa
                dealer1.setCity("NY");
                dealer2.setCity("Yorkshire");
                System.out.println(dealer1.getCity()); //NY
                System.out.println(dealer2.getCity());//Yorkshire
                break;
            }
            case 2:{
                Dealership dealer3 = context.getBean("dealer_sale_hatchback", Dealership.class);
                Dealership dealer4 = context.getBean("dealer_sale_hatchback", Dealership.class);
                System.out.println(dealer3); //Dealership@3835c46
                System.out.println(dealer4);//Dealership@1dde4cb2
                System.out.println(dealer3.getCity()); //Saint Petersburg
                System.out.println(dealer4.getCity()); //Saint Petersburg
                System.out.println(dealer3 == dealer4);  //false - разные объекты
                dealer3.setCity("PITER");
                dealer4.setCity("Ташкент");
                System.out.println(dealer3.getCity()); //PITER
                System.out.println(dealer4.getCity());//Ташкент
                break;
            }
        }
        context.close();
    }
}
