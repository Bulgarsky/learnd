public class Tiles{
    String brand;
    int sizeHeight;
    int sizeWidth;
    int price;
    {
        //инициализатор. для получения данных по умолчанию
        brand = "No Name";
        sizeHeight = 125;
        sizeWidth = 125;
    }
    // Конструкторы:
    Tiles() {
        //стандартный без аргументов
    }
    Tiles(int p) {
        // 1 аргумент: цена
        this.price = p;
    }

    Tiles(String brand, int price) {
        // 2 аргумента
        this.brand = brand;
        this.price = price;
        sizeHeight = 400;
        sizeWidth = 200;
    }
    Tiles(int sizeHeight, int sizeWidth, int price) {
        // 3 аргумента
        brand = "France Collection Summer";
        this.sizeHeight = sizeHeight;
        this.sizeWidth = sizeWidth;
        this.price = price;
    }
    Tiles(String brand, int sizeHeight, int sizeWidth, int price) {
        // 4 аргумента
        this.brand = brand;
        this.sizeWidth = sizeWidth;
        this.sizeHeight = sizeHeight;
        this.price = price;
    }
    //методы:
    void getInfo() {
        System.out.printf("Плитка: %s.  Размеры - Высота: %s, Ширина: %s, Цена: %s \n", brand, sizeHeight, sizeWidth, price);
    }
    void getTilesArea(int sizeHeight, int sizeWidth) {
        float TilesArea = (sizeHeight * sizeWidth)/100;
        System.out.println("Площадь вашей плитки "+brand+ " ("+sizeHeight+" на "+sizeWidth+") = "+TilesArea+" кв.см");
        System.out.println("");
    }

}