package Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dealership {
/*
    //пример 1 - обьект класса реал. интерфейсом
    private Car car;

    @Autowired
    public Dealership(Car car) {
        this.car = car;
    }
    public void getInfo() {
        System.out.println("в магазине продается: " + car.getName() + ". " + car.accelerate() + ". " + car.brake());
    }
*/
    /*
    //пример 2 - конкретный класс
    private Jeep jeep; //@Autowired - внедрение прямо в поле

    @Autowired
    public Dealership(Jeep jeep) {
        this.jeep = jeep;
    }

    /*
    //внедрение через сеттер:
    @Autowired public void setJeep(Jeep jeep) {
        this.jeep = jeep;
    }
    * /
    public void getInfo() {
        System.out.println("в магазине продается: " + jeep.getName() + ". " + jeep.accelerate() + ". " + jeep.brake());
    }
*/
    //Пример 3: внедрение несколько бинов в поля класса
     private Jeep jeep;
     private Hatchback hatchback;

    @Autowired
    public Dealership(Jeep jeep, Hatchback hatchback) {
        this.jeep = jeep;
        this.hatchback = hatchback;
    }
    public void getInfo(){
        System.out.println("в магазине продается: " + jeep.getName() + ". " + jeep.accelerate() + ". " + jeep.brake());
        System.out.println("в магазине продается: " + hatchback.getName() + ". " + hatchback.accelerate() + ". " + hatchback.brake());
    }
}
