import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numerico = new TreeSet<>();
        System.out.println("input number(int): ");
        Scanner in = new Scanner(System.in);
        for (int i=0; true; i++) {
            int userInput = in.nextInt();
            if (!numerico.contains(userInput)) { //== false
                numerico.add(userInput);
            } else {
                System.out.println("duplicate: "+ userInput);
                System.out.println("numerico: "+numerico);
                System.out.println("input number from "+numerico+" to delete");
                break;
            }
        }
        int delete = in.nextInt();
        if (numerico.contains(delete)) { //== true
            numerico.remove(delete);
            System.out.println("deleted: "+delete);
            System.out.println("updated [numerico] is "+numerico);
        } else {
            System.out.println("element: "+delete+" not found in "+numerico);
        }
    }
}