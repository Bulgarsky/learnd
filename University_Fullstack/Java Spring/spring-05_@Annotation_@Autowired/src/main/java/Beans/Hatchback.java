package Beans;
import org.springframework.stereotype.Component;


//@Component
//Если не указать имя: class Name.toLowerCase -> name
//Если имяСоставное: (HatchBack -> hatch_back)
@Component("hatchback_bean")
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
