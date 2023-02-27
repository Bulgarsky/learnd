public abstract class Musical implements Tool {
    private String item;
    private int feature;
    public Musical(String item, int feature){
        this.item = item;
        this.feature = feature;
    }
    public abstract void play();

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
        System.out.println("Играет "+getFeature()+"-струновая "+getItem());
    }
}
//drum
class Drum extends Musical {
    Drum(String item, int feature) {
        super(item, feature);
    }
    @Override
    public  void play() {
        System.out.println("Играет диаметром "+getFeature()+"-мм, Барабан "+getItem());
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
}