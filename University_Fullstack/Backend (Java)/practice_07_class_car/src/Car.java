public class Car {
    //поля
    private String model;
    private String color;
    private String number;
    private int mileage;
    private int fuel;
    private int passenger;

    {
        //инизиализатор
        model = "не заполнено";
        color = "не заполнено";
        number = "не заполнено";
        mileage = 0;
        fuel = 40;
        passenger = 3;

    }
    //МЕТОДЫ
    public void getInfo() {
        System.out.println(
               " Марка : "+ getModel()+
               ", цвет: "+ getColor() +
               ", гос.номер: "+ getNumber() +
               ", пробег: " + getMileage() +
               ", топливo: " +getFuel() +
               ", мест: " + getPassenger()
                );
    }

    //КОНСТРУКТОРЫ
    Car() {
        //без аргументов

    }
    public Car(String model, String color, String number, int mileage, int fuel, int passenger) {
        setModel(model);
        setColor(color);
        setNumber(number);
        setMileage(mileage);
        setFuel(fuel);
        setPassenger(passenger);
    }

    //СЕТТЕРЫ (методы для изменения и уставнки переменных, без прямого дсотупа к основным полям)
    public void setModel(String model) {
        this.model = model;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    //ГЕТТЕРЫ (методы для получения значений переменных)
    public String getModel() {
        return this.model;
    }
    public String getColor() {
        return this.color;
    }
    public String getNumber() {
        return this.number;
    }
    public int getMileage() {
        return mileage;
    }
    public int getFuel() {
        return this.fuel;
    }
    public int getPassenger() {
        return this.passenger;
    }
}
