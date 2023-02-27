public class Main {
    public static void main(String[] args) {
        Musical pot = new Guitar("Кастрюля",0);
        pot.play();
        pot.setItem("Кастрюля суповая ");
        System.out.println("downcasting "+((Guitar)pot).getFeature()); //downcasting
        System.out.println(pot.getItem());

        Guitar balalaika = new Guitar("Балалайка", 4);
        balalaika.play();
        System.out.println(balalaika.getItem()+" имеет характеристику: "+balalaika.getFeature());

        Drum stagg = new Drum("Stagg Classic", 75);
        stagg.play();
        stagg.setItem("Stagg Tim Classic");
        stagg.setFeature(100);
        System.out.println("Updated: "+stagg.getItem()+", "+stagg.getFeature()+" mm");

        Trumpet sax = new Trumpet("Саксафон Conductor", 10);
        sax.play();
        sax.setFeature(15);
        sax.setItem("Saxophone Conductor LY-100");
        System.out.println("Updated: "+sax.getItem()+", "+sax.getFeature()+" mm");
    }
}