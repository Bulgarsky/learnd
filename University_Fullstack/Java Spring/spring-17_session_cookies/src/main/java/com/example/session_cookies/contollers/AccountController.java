package com.example.session_cookies.contollers;

import com.example.session_cookies.models.Auth;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @GetMapping("/account")
    public  String getAccount(HttpServletRequest request){
        HttpSession session = request.getSession();
        Auth authSession = (Auth) session.getAttribute("user");
        if(authSession == null) {
            return "redirect:/auth";
        } else {
            Cookie[] cookies = request.getCookies();
            for (Cookie element: cookies) {
                System.out.println("Cookie name: "+ element.getName());
                System.out.println("Cookie value: "+ element.getValue());
            }
            return "account";
        }
    }

    @GetMapping("/auth")
    public String auth(Model model) {
        model.addAttribute("auth", new Auth());
        return "auth";
    }

    @PostMapping("/auth")
    public String auth(
            @ModelAttribute("auth") Auth auth,
            HttpServletRequest request,
            HttpServletResponse response){

        //create new cookie (key-value). data - String
        Cookie cookie = new Cookie("user_id", "1");
        //указываем сколько будут хранится куки в браузере клиента
        //48 hours * 60 min * 60 sec
        cookie.setMaxAge(48*60*60);
        response.addCookie(cookie);

        HttpSession session = request.getSession();
        Auth authSession = (Auth) session.getAttribute("user");
        authSession = new Auth();
        authSession.setLogin(auth.getLogin());
        authSession.setPassword(auth.getPassword());
        session.setAttribute("user", authSession);
        return "redirect:/account";
    }
}
