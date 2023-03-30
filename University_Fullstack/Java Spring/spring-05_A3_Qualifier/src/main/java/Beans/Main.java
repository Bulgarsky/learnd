package Beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Dealership dealer1 = context.getBean("dealership", Dealership.class);
        dealer1.getInfo();


        context.close();
    }
}
