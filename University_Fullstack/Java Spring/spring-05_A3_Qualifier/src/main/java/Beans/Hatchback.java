package Beans;
import org.springframework.stereotype.Component;


@Component("hatchback")
public class Hatchback implements Car{
    public String accelerate() {
        return "Хетчбек может разгонятся";
    }

    public String brake() {
        return "Хетчбек может тормозить";
    }

    public String getName() {
        return "Хетчбек";
    }
}
