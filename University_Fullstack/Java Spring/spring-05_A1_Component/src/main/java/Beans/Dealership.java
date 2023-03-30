package Beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Dealership {
    private Car car;

    public Dealership(Car car) {
        this.car = car;
    }
    public void getInfo() {
        System.out.println("в магазине продается: " + car.getName() + ". " + car.accelerate() + ". " + car.brake());
    }
}
