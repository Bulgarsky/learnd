package Beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

/*
        //пример 1
        Car car1 = context.getBean("jeep", Car.class);
        Dealership dealer1 = new Dealership(car1); //создаем объект магазина
        dealer1.getInfo();
*/

/*      //без указания какой бин внедрять в консруктор - ошибка
        Car car2 = context.getBean("hatchback", Car.class);
        Dealership dealer2 = new Dealership(car2); //создаем объект магазина
        dealer2.getInfo();
*/
        //Пример 2 - конкретный класс
        Jeep jeep1 = context.getBean("jeep", Jeep.class);
        Dealership dealer1 = new Dealership(jeep1); //создаем объект магазина
        dealer1.getInfo();

        context.close();
    }
}
