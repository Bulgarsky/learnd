public class Dealership {
    private Car car;
    private String city;

    public Dealership(Car car, String city) {
        this.car = car;
        this.city = city;
    }
    public Dealership() {} //default constructor

    //setters
    public void setCar(Car car) {this.car = car;}
    public void setCity(String city) {this.city = city;}

    //getters
    public Car getCar() {return car;}
    public String getCity() {return city;}

    public void getInfo() {
        System.out.println("в магазине продается: " + car.getName() + ". " + car.accelerate() + ". " + car.brake());
    }


}