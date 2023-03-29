public class CarDealership {
    private Car car;

    /* не сооотвестует IoC, привязан к конкретному авто
    public CarDealership() {
        this.car = new Hatchback();
    }
    */

    //IoC, в качестве параметра принимается object интерфейса. слабосвязнй код
    public CarDealership(Car car) {
        this.car = car;
    }
    public void getInfo() {
        System.out.println("в магазине продается: " + car.getName() + ". " + car.accelerate() + ". " + car.brake());
    }
}
