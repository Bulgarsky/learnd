//подключение классов
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("RU: Целые числа. Введите длину одномерного массива: ");
        //запись считанного значение в переменную line:
        int line = in.nextInt();
        //инизиализация массива c длинной line:
        int[] firstArray = new int[line];
        //цикл для заполенния массива:
        for (int i = 0; i < firstArray.length; i++) {
            System.out.print("RU: Введите элемент [" + i + "]= ");
            //считывание введенных элементов и запись в массив
            firstArray[i] = in.nextInt();
        }
        //вывод одномерного массива переведенного в строку:
        System.out.println("input Array (.toString): " + Arrays.toString(firstArray));

        //Сортировка массива:
        Arrays.sort(firstArray);
        //вывод одномерного массива:
        System.out.println("Sorted Array (.toString): " + Arrays.toString(firstArray));
        //вывод одномерного массива через цикл:
        System.out.print("Sorted Array (for): [");
        for (int i : firstArray) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }
}
