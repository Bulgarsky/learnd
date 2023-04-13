import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        //созд onj для отправки http requests
        RestTemplate restTemplate = new RestTemplate();
        //System.out.println(restTemplate.getForObject("https://reqres.in/api/users?page=2", String.class));


        /*
        //HashMap, add to json
        Map<String, String> json = new HashMap<>();
        json.put("name", "John Doe");
        json.put("job", "Builder Quality");
        HttpEntity<Map<String, String>> request = new HttpEntity<>(json);
        System.out.println(restTemplate.postForEntity("https://reqres.in/api/users", request, String.class));
        */

        //получение json с user/2
        String response = restTemplate.getForObject("https://reqres.in/api/users/2", String.class);
        System.out.println(response);

        //parsing json w/ Jackson (преобразуем строки в объект
        ObjectMapper mapper = new ObjectMapper();
        JsonNode obj = mapper.readTree(response);
        System.out.println("email: "+obj.get("data").get("email"));
        System.out.println("lastName: "+obj.get("data").get("last_Name"));
        System.out.println("firstName: "+obj.get("data").get("first_name"));
        System.out.println("avatar: "+obj.get("data").get("avatar"));

    }
}
