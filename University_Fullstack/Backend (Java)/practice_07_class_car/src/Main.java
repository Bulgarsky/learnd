public class Main {
    public static void main(String[] args) {
        Car Lada = new Car();
        Lada.setModel("2114");
        // строка для выбора ошибки изза ограничения мест:
        //Car Mersedes = new Car("Mersedes-Benz Sprinter", "White", "x325ba 199", 45000000, 80, 20);
        Car Mersedes = new Car("Mersedes-Benz Sprinter", "White", "x325ba 199", 45000000, 80, 8);
        Car Volkswagen = new Car("VW Amarok", "Blue Sky", "a131км 102", 5200000, 65, 4);
        Car Skoda = new Car("Skoda Oktavia", "Black", "c100cb 16", 145000000, 35, 3);

        Lada.getInfo();
        Mersedes.getInfo();
        Volkswagen.getInfo();
        Skoda.getInfo();

        System.out.println("");

        Skoda.setFuel(20);
        Skoda.setMileage(147500000);
        //строка для выброса ошибки при превышении одометра пробега:
        ///Skoda.setMileage(1000000000);
        Skoda.setPassenger(1);
        System.out.println("у авто "+Skoda.getModel()+" теперь пробег = "+Skoda.getMileage()+" км, осталось топлива: "+Skoda.getFuel()+" литров и посадочных мест осталось: "+Skoda.getPassenger());

        System.out.println("Пробег у "+Volkswagen.getModel()+" = "+Volkswagen.getMileage()+" км");
        System.out.println("Количество посадочных мест у "+Lada.getModel()+" = "+Lada.getNumber());
        System.out.println("у авто "+Mersedes.getModel()+" цвет - "+Mersedes.getColor());
        System.out.println("у авто "+Volkswagen.getModel()+" гос.номер - "+Volkswagen.getNumber());
    }
}