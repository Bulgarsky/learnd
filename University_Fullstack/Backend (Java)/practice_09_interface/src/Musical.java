public abstract class Musical implements Instrument {
    private String item;
    private int feature;
    public Musical(String item, int feature){
        this.item = item;
        this.feature = feature;
    }
    public abstract void play();
    public abstract void printInfo();

    public String getItem() {
        return item;
    }
    public int getFeature() {
        return feature;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public void setFeature(int feature) {
        this.feature = feature;
    }
}

class Guitar extends Musical {
    Guitar(String item, int feature) {
        super(item, feature);
    }
    @Override
    public void play() {
        System.out.println("Играет "+getFeature()+"-струнная "+getItem());
    }
    public void printInfo(){
        System.out.println("Инструмент: "+getItem()+", щипковый "+getFeature()+"-струнный музыкальный инструмент ("+getClass()+")");
    };
}
//drum
class Drum extends Musical {
    Drum(String item, int feature) {
        super(item, feature);
    }
    @Override
    public  void play() {
        System.out.println("Играет диаметром "+getFeature()+"-дюймов, Барабан "+getItem());
    }
    @Override
    public void printInfo(){
        System.out.println("Инструмент: "+getItem()+", ударный "+getFeature()+"-дюймовый барабан ("+getClass()+")");
    }
}

//trumpet
class Trumpet extends Musical {
    Trumpet(String item, int feature) {
        super(item, feature);
    }

    @Override
    public  void play() {
        System.out.println("Играет диаметром "+getFeature()+"-мм, труба "+getItem());
    }
    @Override
    public void printInfo(){
        System.out.println("Инструмент: "+getItem()+", духовая труба диаметром "+getFeature()+"-мм ("+getClass()+")");
    }

}