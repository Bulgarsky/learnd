import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fruits = new ArrayList<>();
        // add elements
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("peach");
        // print
        System.out.println("fruits.size("+fruits.size()+"): "+fruits);

        //remove element
        fruits.remove("peach");
        System.out.println("fruits.size("+fruits.size()+"): "+fruits);

        //add w/ index
        fruits.add(1, "peach");
        System.out.println("fruits.size("+fruits.size()+"): "+fruits);

        String elementFruits = fruits.get(0);
        int index = fruits.indexOf(elementFruits);
        fruits.remove(index);
        System.out.println("Delete: "+index+"-element is "+elementFruits);
        System.out.println("fruits.size("+fruits.size()+"): "+fruits);

        for (String element: fruits) {
            System.out.println(fruits.indexOf(element)+" "+ element);
        }
        fruits.add(index, elementFruits);
        fruits.add(2,"melon");
        fruits.add("banana");
        System.out.println("fruits.size("+fruits.size()+"): "+fruits);
        for (String element: fruits) {
            System.out.println(fruits.indexOf(element)+" "+ element);
        }
    }
}