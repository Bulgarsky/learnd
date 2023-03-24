import java.util.Objects;

public class Product {
    String productNO;
    String item;
    String price;
    String description;

    public Product(String productNO, String item, String price, String description) {
        this.productNO = productNO;
        this.item = item;
        this.price = price;
        this.description = description;
    }

    //getters
    public String getProductNO() {return productNO;}
    public String getItem() {return item;}
    public String getPrice() {return price;}
    public String getDescription() {return description;}

    //setters
    public void setProductNO(String productNO) {this.productNO = productNO;}
    public void setItem(String item) {this.item = item;}
    public void setPrice(String price) {this.price = price;}
    public void setDescription(String description) {this.description = description;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productNO, product.productNO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNO);
    }

    @Override
    public String toString() {
        return
                " артикул: '" + productNO + '\'' +
                ", наименование: '" + item + '\'' +
                ", цена: '" + price + '\'' +
                ", описание: '" + description + '\''
                ;
    }
}
