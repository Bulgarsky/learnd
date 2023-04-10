package com.example.session_cookies.contollers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    public int ID = 1;
    public int numberOfLoginsToTheSite = 1;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer numberOfLoginsToTheSiteSession = (Integer) session.getAttribute("numberOfLoginsToTheSite");
        Integer id = (Integer) session.getAttribute("id");
        if(numberOfLoginsToTheSiteSession == null) {
            session.setAttribute("numberOfLoginsToTheSite", numberOfLoginsToTheSite);
            numberOfLoginsToTheSite++;
        }else {
            session.setAttribute("numberOfLoginsToTheSite", numberOfLoginsToTheSite++);
        }

        if(id == null) {
            session.setAttribute("id", ID);
            ID++;
        }
        return "index";
    }
}
