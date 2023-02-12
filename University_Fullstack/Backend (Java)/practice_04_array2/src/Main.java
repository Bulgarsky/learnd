//подключение классов

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("RU: Целые числа. Введите кол-во строк массива: ");
        int line = in.nextInt();
        System.out.print("RU: Введите кол-во столбцов массива: ");
        int column = in.nextInt();
        //инициализация массива
        int[][] secondArray = new int[line][column];

        //цикл для заполенния массива:
        for (int i = 0; i < secondArray.length; i++) {
            for (int j = 0; j < secondArray[0].length; j++) {
                System.out.print("RU: Введите элемент [" + i + ", " + j + "]= ");
                //считывание введенных элементов и запись в массив
                secondArray[i][j] = in.nextInt();
            }
        }

        int arrayElementSum = 0;
        //цикл для переборки элементов двумерного массива:
        for (int[] lines : secondArray) {
            for (int sumLines : lines) {
                //суммирование
                arrayElementSum = arrayElementSum + sumLines;
            }
        }
        System.out.print("RU: Сумма элементов массива = " + arrayElementSum);
    }
}
