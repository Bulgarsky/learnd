package Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("dealership")
public class Dealership {
    private Car car;


    public Dealership(Car car) {
        this.car = car;
    }
    public void getInfo() {
        System.out.println("в магазине продается: " + car.getName() + ". " + car.accelerate() + ". " + car.brake());
    }

}
