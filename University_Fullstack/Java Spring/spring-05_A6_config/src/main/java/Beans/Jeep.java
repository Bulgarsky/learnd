package Beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("jeep") @Scope("prototype")
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
