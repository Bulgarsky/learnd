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
        //System.out.println("");
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
               ", пробег: " + getMileage() + " км" +
               ", осталось: " +getFuel() + " литров бензина" +
               ", пассажирских мест: " + getPassenger()
                );
    }

    //КОНСТРУКТОРЫ
    Car() {
        //без аргументов
    }
    public Car(String model, String color, String number, int mileage, int fuel, int passenger) {
        this.model = model;
        this.color = color;
        this.number = number;
        this.mileage = mileage;
        this.fuel = fuel;
        this.passenger = passenger;
        /*
        setModel(model);
        setColor(color);
        setNumber(number);
        setMileage(mileage);
        setFuel(fuel);
        setPassenger(passenger);
        */
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
        //проверка
        if (mileage<=999999999) {
            this.mileage = mileage / 1000;
        }
        else {
            throw  new RuntimeException("Введенные данные ("+getMileage() +
                    " в метрах) превышают ограничения одометра пробега (999 999 км)");
        }
    }
    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
    public void setPassenger(int passenger) {
        //проверка
        if (passenger<=8) {
            this.passenger = passenger;
        }
        else {
            throw  new RuntimeException(getModel()+" количество посадочных мест не должно превышать 8 ");
        }
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
