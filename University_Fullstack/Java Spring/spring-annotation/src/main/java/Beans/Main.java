package Beans;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Dealership dealer1 = context.getBean("Dealership", Dealership.class);
        System.out.println(dealer1.getCity());
        System.out.println(dealer1.getEmployeeValue());
        context.close();
    }
}
