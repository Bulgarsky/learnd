package Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("dealership")
public class Dealership {
    @Autowired @Qualifier("jeep")
    private Jeep jeep;
    @Autowired @Qualifier("hatchback")
    private Hatchback hatchback;

    @Autowired
    public Dealership(@Qualifier("jeep")Jeep jeep, @Qualifier("hatchback")Hatchback hatchback) {
        this.jeep = jeep;
        this.hatchback = hatchback;
    }
    public void getInfo() {
        System.out.println("в магазине продается: " + jeep.getName() + ". " + jeep.accelerate() + ". " + jeep.brake());
        System.out.println("в магазине продается: " + hatchback.getName() + ". " + hatchback.accelerate() + ". " + hatchback.brake());
    }
}
