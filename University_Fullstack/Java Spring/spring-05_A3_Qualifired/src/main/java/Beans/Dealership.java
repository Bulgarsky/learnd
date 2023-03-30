package Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
public class Dealership {
    private Jeep jeep;

    @Autowired
    public Dealership(Jeep jeep) {
        this.jeep = jeep;
    }
    public void getInfo() {
        System.out.println("в магазине продается: " + jeep.getName() + ". " + jeep.accelerate() + ". " + jeep.brake());
    }
}
