package com.example.market.controllers;

import com.example.market.enumm.Status;
import com.example.market.models.Cart;
import com.example.market.models.Order;
import com.example.market.models.Person;
import com.example.market.models.Product;
import com.example.market.security.PersonDetails;
import com.example.market.services.CartService;
import com.example.market.services.OrderService;
import com.example.market.services.ProductService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class UserOrderController {
    private final ProductService productService;
    private final CartService cartService;
    private final OrderService orderService;
    private final AuthenticationController authController;

    public UserOrderController(ProductService productService, CartService cartService, OrderService orderService, AuthenticationController authController) {
        this.productService = productService;
        this.cartService = cartService;
        this.orderService = orderService;
        this.authController = authController;
    }

    //ЗАКАЗ: создать
    @GetMapping("/order/create")
    public String orderCreate(){
        Person currentPerson = authController.getCurrentAuthPerson();

        List<Cart> cartList = cartService.findByPersonId(currentPerson.getId());
        List<Product> productList = new ArrayList<>();

        //получить продукты из корзины по id товара
        for (Cart item: cartList) {
            productList.add(productService.getProductId(item.getProductId()));
        }

        //итоговая цена заказа
        float totalPrice = 0;
        for (Product item: productList) {
            totalPrice += item.getPrice();
        }
        //добавить соли номер заказ
        String uuid = UUID.randomUUID().toString();

        for (Product product: productList) {
            Order newOrder = new Order(uuid, product, currentPerson, 1, product.getPrice(), Status.Принят);
            orderService.saveOrder(newOrder);

            //очистить корзину
            cartService.deleteItemFromCart(product.getId());
        }

        return "redirect:/orders";
    }

    //Пользователь: вывести все заказы
    @GetMapping("/orders")
    public String userOrder(Model model){
        Person currentPerson = authController.getCurrentAuthPerson();
        List<Order> orderList = orderService.findOrderByPerson(currentPerson);

        model.addAttribute("userOrderCount", orderList.size());
        model.addAttribute("userOrders", orderList);
        model.addAttribute("userAuth", currentPerson);
        return "user/orders";
    }

    //Пользователь: открыть список активных заказов
    @GetMapping("/user/order/active")
    public String userOrderActive(Model model){
        Person currentPerson = authController.getCurrentAuthPerson();
        List<Order> orderActiveList = orderService.findOrderByStatusActive(currentPerson);

        model.addAttribute("userOrderActive",orderActiveList);
        model.addAttribute("orderActiveCount", orderActiveList.size());
        model.addAttribute("userAuth", currentPerson);
        return "user/order/orderActive";
    }

    //Пользователь: открыть список активных заказов
    @GetMapping("/user/order/history")
    public String userOrderHistory(Model model){
        Person currentPerson = authController.getCurrentAuthPerson();
        List<Order> orderFinishList = orderService.findOrderByStatusHistory(currentPerson);

        model.addAttribute("userOrderHistory", orderFinishList);
        model.addAttribute("orderFinishCount", orderFinishList.size());
        model.addAttribute("userAuth", currentPerson);
        return "user/order/orderHistory";
    }

}
