package Beans;

public class Dealership {
    private Car car;

    /* не сооотвестует IoC, привязан к конкретному авто
    public Beans.CarDealership() {
        this.car = new Beans.Hatchback();
    }
    */

    //IoC, в качестве параметра принимается object интерфейса. слабосвязнй код
    public Dealership(Car car) {
        this.car = car;
    }
    public void getInfo() {
        System.out.println("в магазине продается: " + car.getName() + ". " + car.accelerate() + ". " + car.brake());
    }
}
