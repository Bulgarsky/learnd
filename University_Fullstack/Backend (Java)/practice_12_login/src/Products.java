public class Products {
    private String code;
    private String name;
    private String description;

    public Products (String name, String code, String description) {
        this.name = name;
        this.code = code;
        this.description = description;
    };

    //getters
    public String getCode() {return code;}
    public String getName() {return name;}
    public String getDescription() {return description;}

    //setters
    public void setCode(String code) {this.code = code;}
    public void setName(String name) {this.name = name;}
    public void setDescription(String description) {this.description = description;}

}
