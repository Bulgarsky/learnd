public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Car Lada = new Car();
        Lada.setModel("2114");

        Car Mersedes = new Car("Mersedes-Benz Sprinter", "White", "x325ba 199", 45000, 80, 10);
        Car Volkswagen = new Car("VW Amarok", "Blue Sky", "a131км 102", 5200, 65, 4);
        Car Skoda = new Car("Skoda Oktavia", "Black", "c100cb 16", 145000, 35, 3);

        Lada.getInfo();
        Mersedes.getInfo();
        Volkswagen.getInfo();
        Skoda.getInfo();

        Skoda.setFuel(20);
        Skoda.setMileage(147000);
        Skoda.setPassenger(1);
        Skoda.getInfo();
    }
}