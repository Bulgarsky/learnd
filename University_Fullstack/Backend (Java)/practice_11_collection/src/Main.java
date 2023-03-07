import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numerico = new TreeSet<>();
        System.out.println("input number(int): ");
        Scanner in = new Scanner(System.in);
        //бесконечный цикл
        for (int i=0; true; i++) {
            int userInput = in.nextInt();
            if (!numerico.contains(userInput)) { //== false
                numerico.add(userInput);
            } else {
                //вывoд дубликата
                System.out.println("duplicate: "+ userInput);
                // вывод [размер] элементы
                System.out.println("numerico["+numerico.size()+"]: "+numerico);
                //переборка и вывод элементов по отдельности
                for (int element: numerico) {
                    System.out.println(element);
                }
                //сообщение о необходимости удаления
                System.out.println("input number from "+numerico+" to delete");
                break; // прерывание цикла в случае перехода в else
            }
        }
        //получение числа для удаления
        int delete = in.nextInt();
        //сравнение
        if (numerico.contains(delete)) { //== true
            numerico.remove(delete);
            System.out.println("deleted: "+delete); //вывод удаленног числа
            //вывод обновленного набора
            System.out.println("updated numerico["+numerico.size()+"] is "+numerico);
        } else {
            //вывод информации об отсутствии
            System.out.println("element: "+delete+" not found in "+numerico);
        }
    }
}