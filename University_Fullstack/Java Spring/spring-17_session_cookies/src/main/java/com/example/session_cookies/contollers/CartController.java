package com.example.session_cookies.contollers;

import com.example.session_cookies.models.Cart;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {

    @GetMapping("/cart")
    public String cart(Model model){
        return "cart";
    }

    @GetMapping("product/add/in/cart")
    public String getTemplateAddProductInCart(Model model){
        model.addAttribute("cart", new Cart());
        return "addProductInCart";
    }

    @PostMapping("product/add/in/cart")
    public String AddProductInCart(@ModelAttribute("cart") Cart cart,
        HttpServletRequest request){
        HttpSession session = request.getSession();

        Cart cartSession = (Cart) session.getAttribute("cart");
        cartSession = new Cart(cart.getProductName(),  cart.getAmount(), cart.getPrice());
//        cartSession.setProductName(cart.getProductName());
//        cartSession.setPrice(cart.getPrice());
//        cartSession.setAmount(cart.getAmount());
        session.setAttribute("cart", cartSession);

        return "redirect:/cart";
    }
}
