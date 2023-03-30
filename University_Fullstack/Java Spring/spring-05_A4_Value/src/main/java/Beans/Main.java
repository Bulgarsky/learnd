package Beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Dealership dealer1 = context.getBean("dealership", Dealership.class);
        System.out.println(dealer1.getAddress()+", "+dealer1.getEmployeeValue());


        context.close();
    }
}
