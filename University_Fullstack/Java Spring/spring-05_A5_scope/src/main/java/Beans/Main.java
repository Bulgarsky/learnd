package Beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        Jeep jeep1 = context.getBean("jeep", Jeep.class);
//        Jeep jeep2 = context.getBean("jeep", Jeep.class);
//        System.out.println(jeep1+", "+jeep2);
//        System.out.println(jeep1 == jeep2); //false

        Hatchback hatchback1 = context.getBean("hatchback", Hatchback.class);
        Hatchback hatchback2 = context.getBean("hatchback", Hatchback.class);
        System.out.println(hatchback1 +", "+ hatchback2);
        System.out.println(hatchback1 == hatchback2); //true

        context.close();
    }
}
