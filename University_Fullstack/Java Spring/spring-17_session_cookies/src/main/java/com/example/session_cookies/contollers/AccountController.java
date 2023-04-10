package com.example.session_cookies.contollers;

import com.example.session_cookies.models.Auth;
import jakarta.servlet.http.HttpServletRequest;
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
            HttpServletRequest request){
        HttpSession session = request.getSession();
        Auth authSession = (Auth) session.getAttribute("user");
        authSession = new Auth();
        authSession.setLogin(auth.getLogin());
        authSession.setPassword(auth.getPassword());
        session.setAttribute("user", authSession);
        return "redirect:/account";
    }
}
