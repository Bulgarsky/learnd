import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("HashMap. Key, Value. unsorted, no save position. KEY UNIQUE, value can be duplicates");
        HashMap<Integer, String> market = new HashMap<>();
        market.put(1, "book");
        market.put(2, "pen");
        market.put(3, "glass");
        market.put(4, "liner");
        market.put(5, "liner");
        System.out.println(market);


    }
}