package Beans;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("hatchback") @Scope("singleton") @Lazy //lazy bean будет создан при обращении к таковому
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
