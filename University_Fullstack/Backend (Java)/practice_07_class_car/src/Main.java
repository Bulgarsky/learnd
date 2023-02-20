public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Car Lada = new Car();
        Lada.setModel("2114");
        // строка для выбора ошибки изза ограничения мест:
        Car Mersedes = new Car("Mersedes-Benz Sprinter", "White", "x325ba 199", 45000000, 80, 20);
        //Car Mersedes = new Car("Mersedes-Benz Sprinter", "White", "x325ba 199", 45000000, 80, 8);
        Car Volkswagen = new Car("VW Amarok", "Blue Sky", "a131км 102", 5200000, 65, 4);
        Car Skoda = new Car("Skoda Oktavia", "Black", "c100cb 16", 145000000, 35, 3);

        Lada.getInfo();
        Mersedes.getInfo();
        Volkswagen.getInfo();
        Skoda.getInfo();

        System.out.println("");

        Skoda.setFuel(20);
        Skoda.setMileage(14750000);
        //строка для выброса ошибки при превышении одометра пробега:
        ///Skoda.setMileage(1000000000);
        Skoda.setPassenger(1);
        System.out.println("у авто "+Skoda.getModel()+" текущий пробег = "+Skoda.getMileage()+" осталось топлива: "+Skoda.getFuel()+" и посадочных мест осталось: "+Skoda.getPassenger());

        System.out.println("Пробег у "+Volkswagen.getModel()+" = "+Volkswagen.getMileage());
        System.out.println("Количество посадочных мест у "+Lada.getModel()+" = "+Lada.getNumber());
        System.out.println("Цвет у "+Mersedes.getModel()+" = "+Mersedes.getColor());
    }
}