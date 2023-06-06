package com.example.market.controllers;

import com.example.market.models.Order;
import com.example.market.models.Person;
import com.example.market.models.Product;
import com.example.market.security.PersonDetails;
import com.example.market.services.OrderService;
import com.example.market.services.ProductService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;
    private final OrderService orderService;
    private final AuthenticationController authController;

    public ProductController(ProductService productService, OrderService orderService, AuthenticationController authController) {
        this.productService = productService;
        this.orderService = orderService;
        this.authController = authController;
    }

    //получение полной информации о товаре по id. убрать в другое место /под удаление/
    @GetMapping("/account/product/info/{id}")
    public String productInfo2(@PathVariable("id") int id, Model model){
        model.addAttribute("userAuth", authController.getCurrentAuthPerson());
        model.addAttribute("product", productService.getProductId(id));
        return "/user/info";
    }
    //получить информацию о товаре по id
    @GetMapping("/product/info/{id}")
    public String productInfo(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.getProductId(id));
        return "/product/info";
    }

    //получение всех товаров
    @GetMapping("/product")
    public String getAllProduct(){
        return "redirect:/index";
    }



    //получить список купленных пользователем товаров, и передать в view (для покупателя)
    @GetMapping("/user/product/bought")
    public String productBought(
            Model model){
        Person currentPerson = authController.getCurrentAuthPerson();
        List<Product> userProductList =  new ArrayList<>();

        List<Order> userOrderList = orderService.findByPersonId(currentPerson.getId());
        for (Order order: userOrderList) {
            if(!userProductList.contains(order.getProduct())) {
                userProductList.add(productService.getProductId(order.getProduct().getId()));
            }
        }

        model.addAttribute("userAuth", currentPerson);
        model.addAttribute("userProductsBought", userProductList);
        model.addAttribute("boughtProductsCount", userOrderList.size());

        //добавить проверку роли -> возвращение нужной view
        return "/user/productsBought";
    }

}
