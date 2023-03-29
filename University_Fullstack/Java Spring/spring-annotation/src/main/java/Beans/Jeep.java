package Beans;

import org.springframework.stereotype.Component;

//@Component("jeep_bean")
@Component()
public class Jeep implements Car{
    public String accelerate() {
        return "Внедорожник может разгонятся";
    }
    public String brake() {
        return "Внедорожник может тормозить";
    }
    public String getName() {
        return "Внедорожник";
    }
}
