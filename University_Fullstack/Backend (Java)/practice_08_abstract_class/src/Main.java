
public class Main {
    public static void main(String[] args) {

        Book ognivo = new Book("Ognivo", "pushkin", 2000, "Rusmedia");
        ognivo.printInfo();
        Article marshal = new Article("Market Crash day", "Marshal", "NY Times", 2, 2023);
        marshal.printInfo();
        Ebook tompson = new Ebook("Beast history", "Harry Tompson", "www.tompson/ebooks", "life of wilds");
        tompson.printInfo();
        System.out.println(" --  --  --  -- ");

        tompson.setTitle("Wild. Beast");
        tompson.setAuthor("Harry J. Thompson");
        tompson.setSynopsis("Wild. After humans become");
        tompson.printInfo();

        String a = marshal.getTitle();
        String b = ognivo.getPublisher();
        System.out.println(a+", "+b);
    }
}