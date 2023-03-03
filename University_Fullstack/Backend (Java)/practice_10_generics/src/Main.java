public class Main {
    public static void main(String[] args) {
        Order order1 = new Order <Integer, Integer, Boolean> (1, 2, true);
        Order order2 = new Order <String, String, Integer> ("order2", "Popov A S", 0);
        Order order3 = new Order <Integer, String, String> (3, "Sergey Davydov", "Cancel");
        order1.printInfo();
        order2.printInfo();
        order3.printInfo();
        System.out.println("---------");
        order1.typesInfo();
        order2.typesInfo();
        order3.typesInfo();

        order1.setStatus(false);
        order2.setStatus(3);
        order3.setStatus("Done");
        System.out.println(order1.getStatus());
        System.out.println(order2.getStatus());
        System.out.println(order3.getStatus());
        System.out.println("---------");
        order1.printInfo();
        order2.printInfo();
        order3.printInfo();
    }
}