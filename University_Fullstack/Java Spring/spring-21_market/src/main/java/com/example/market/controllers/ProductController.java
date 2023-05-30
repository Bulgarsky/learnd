package com.example.market.controllers;

import com.example.market.models.Order;
import com.example.market.models.Person;
import com.example.market.models.Product;
import com.example.market.models.ShippingAddress;
import com.example.market.repositories.ProductRepository;
import com.example.market.security.PersonDetails;
import com.example.market.services.OrderService;
import com.example.market.services.ProductService;
import com.example.market.services.ShippingAddressService;
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
    private final ProductRepository productRepository;
    private final OrderService orderService;
    private final ShippingAddressService shippingAddressService;

    public ProductController(ProductService productService, ProductRepository productRepository, OrderService orderService, ShippingAddressService shippingAddressService) {
        this.productService = productService;
        this.productRepository = productRepository;

        this.orderService = orderService;

        this.shippingAddressService = shippingAddressService;
    }

    //получение всех товаров
    @GetMapping("/product")
    public String getAllProduct(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "/product/products";
    }

    //получить информацию о товаре по id
    @GetMapping("/product/info/{id}")
    public String productInfo(@PathVariable("id") int id, Model model){

        model.addAttribute("product", productService.getProductId(id));
        return "/product/info";
    }



    //получить список купленных пользователем товаров, и передать в view
    @GetMapping("/user/product/bought")
    public String productBought(
            Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        int id_person = personDetails.getPerson().getId();
        List<Product> userProductList =  new ArrayList<>();
        int userProductBoughtCount = 0;
        List<Order> userOrderList = orderService.findByPersonId(id_person);
        for (Order order: userOrderList) {
            if(!userProductList.contains(order.getProduct())) {
                userProductList.add(productService.getProductId(order.getProduct().getId()));
                userProductBoughtCount+=1;
            }
        }

        model.addAttribute("userAuth", personDetails.getPerson());
        model.addAttribute("userProductsBought", userProductList);
        model.addAttribute("userProductBoughtCount", userProductBoughtCount);
        //добавить проверку роли -> возвращение нужной view
        return "/user/productsBought";
    }

}
