public class Dealership {
    private Car car;

    /* не сооотвестует IoC, привязан к конкретному авто
    public CarDealership() {
        this.car = new Hatchback();
    }
    */

    //IoC, в качестве параметра принимается object интерфейса. слабосвязнй код
    public Dealership(Car car) {
        this.car = car;
    }
    public Dealership() {} //default constructor
    public void getInfo() {
        System.out.println("в магазине продается: " + car.getName() + ". " + car.accelerate() + ". " + car.brake());
    }

    public void setCar(Car car) {
        this.car = car;
    }
}