package Beans;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("carDealership")
public class Dealership {
 private Car car;

 @Value("${CarDealership.city1}")
 private String city;
 @Value("${CarDealership.employeeValue1}")
 private int employeeValue;

 public Car getCar() {
  return car;
 }

 public String getCity() {
  return city;
 }

 public int getEmployeeValue() {
  return employeeValue;
 }

/*
 @Autowired //пододут все обьекты интерфейса и выкинет ошибку
 public CarDealership(Car car) {
     this.car = car;
 }

 //setters
 public void setCar(Car car) {this.car = car;}

 //getters
 public Car getCar() {return car;}
 public void getInfo() {
     System.out.println("в магазине продается: " + car.getName() + ". " + car.accelerate() + ". " + car.brake());
 }
*/

/*
    @Autowired @Qualifier("jeep")
    private Jeep jeep;
    @Autowired @Qualifier("hatchback")
    private Hatchback hatchback;

    @Autowired
    public CarDealership(@Qualifier("hatchback")Hatchback hatchback, @Qualifier("jeep")Jeep jeep) {
        this.hatchback = hatchback;
        this.jeep = jeep;
    }
    public void getInfo() {
        System.out.println("в магазине продается: " + jeep.getName() + ". " + jeep.accelerate() + ". " + jeep.brake());
    }


    //@Autowired
    public void setJeep(Jeep jeep) {
        this.jeep = jeep;
    }
    //@Autowired - не смотрит на модификатор поля
*/
}