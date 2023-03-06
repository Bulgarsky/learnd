import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        System.out.println("HashSet. NO duplicates");
        Set<String> vegs = new HashSet<>();
        vegs.add("tomato");
        vegs.add("pumbkin");
        vegs.add("cucumber");
        System.out.println("vegs: "+vegs);


        if (vegs.contains("apple") == true) {
            System.out.println("! apple on vegs !");
        }
        else {
            vegs.add("apple");
            System.out.println("updated vegs: "+vegs);
        }
        int i = 0;
        for (String element: vegs) {
            i++;
            System.out.println(i+": "+element);
        }
    }
}