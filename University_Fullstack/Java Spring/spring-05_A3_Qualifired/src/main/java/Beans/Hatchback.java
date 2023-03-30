package Beans;
import org.springframework.stereotype.Component;

//Если указать два класса реализумые интерфейсом, и использовать autowired - будет ошибка (нет конкретного указания какой бин внедрять)
//@Component
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
