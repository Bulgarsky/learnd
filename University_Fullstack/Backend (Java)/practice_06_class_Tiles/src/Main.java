import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Tiles Noname = new Tiles(); // исп. стандартного конструктора
        Noname.getInfo(); //метод - получить инфу

        Tiles Russia = new Tiles();
        Russia.brand = "Russia Omsk";
        Russia.sizeHeight = 200;
        Russia.sizeWidth = 200;
        Russia.price = 100;

        Russia.getInfo();

        Tiles India = new Tiles(200); // передача 1 арг
        India.getInfo();

        Tiles Italy = new Tiles("Italy Roma", 500); // исп. конструктора с передачей 2 аргументов
        Italy.getInfo();

        Tiles France = new Tiles(350, 400, 550); //исп. конструктора с передачей 3 аргументов
        France.getInfo();

        Tiles Canada = new Tiles("Canadian Winter", 150, 450, 750); // 4
        Canada.getInfo();



       Canada.getTilesArea(Canada.sizeHeight, Canada.sizeWidth);
       getTilesAmount(Canada.sizeHeight, Canada.sizeWidth);

       France.getTilesArea(France.sizeHeight, France.sizeWidth);
       getTilesAmount(France.sizeHeight, France.sizeWidth);
        }
    static void getTilesAmount(int sizeHeight, int sizeWidth) {
        double tilesArea = (sizeHeight * sizeWidth)/100;
//        System.out.println("Площадь вашей плитки "+tilesArea+" кв.см");
        Scanner in = new Scanner(System.in);
        System.out.print("Введите общую площадь в кв.метрах = ");
        double workArea = in.nextDouble();
        double result = (workArea*10000) / tilesArea;
        System.out.println("Необходимое кол-во плитки для площади " +workArea+ " кв.м = "+ result + " штук");
        System.out.println("");
    }
}

