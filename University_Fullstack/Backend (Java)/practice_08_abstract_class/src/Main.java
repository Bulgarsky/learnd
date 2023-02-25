
public class Main {
    public static void main(String[] args) {

        Book Ognivo = new Book("Ognivo", "pushkin", 2000, "Rusmedia");
        Ognivo.printInfo();
        Article Marshal = new Article("Market Crash day", "Marshal", "NY Times", 2, 2023);
        Marshal.printInfo();
        Ebook Tompson = new Ebook("Beast history", "Harry Tompson", "www.tompson/ebooks", "life of wilds");
        Tompson.printInfo();
        System.out.println(" --  --  --  -- ");

        Tompson.setTitle("Wild. Beast");
        Tompson.setAuthor("Harry J. Thompson");
        Tompson.setSynopsis("Wild. After humans become");
        Tompson.printInfo();

        String a = Marshal.getTitle();
        String b = Ognivo.getPublisher();
        System.out.println(a+", "+b);
    }
}