import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("TreeSet. Unique elements. Sorted ABC");
        TreeSet<String> cars = new TreeSet<>();
        cars.add("lada");
        cars.add("scoda");
        cars.add("benz");
        cars.add("volcwagen");
        System.out.println("[cars]: "+ cars);
        if (!cars.contains("moskvich")) {
            System.out.println("[cars] not have got it");

        }
        System.out.println("first on [cars] is ["+cars.first()+"]");
        System.out.println("last on [cars] is ["+cars.last()+"]");
        cars.add("moskvich");
        cars.add("aston");

        for (String element:cars) {
            System.out.println(element);
        }
        TreeSet<Integer> numerico = new TreeSet<>();
        numerico.add(1);
        numerico.add(25);
        numerico.add(181);
        numerico.add(451);
        System.out.println("numerico "+numerico);
        //возвращает следующий ДО 181 элемент
        System.out.println("lower 181 [numerico] is ["+numerico.lower(181)+"]");
        //возврает следующие после 181 элемент
        System.out.println("higher 181 [numerico] is ["+numerico.higher(181)+"]");

        System.out.println("cars["+cars.size()+"]");
        System.out.println("numerico["+numerico.size()+"]");

    }
}