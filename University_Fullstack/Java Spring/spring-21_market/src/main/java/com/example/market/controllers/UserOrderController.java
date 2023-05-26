package com.example.market.controllers;

import com.example.market.enumm.Status;
import com.example.market.models.Cart;
import com.example.market.models.Order;
import com.example.market.models.Product;
import com.example.market.models.ShippingAddress;
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

    public UserOrderController(ProductService productService, CartService cartService, OrderService orderService) {
        this.productService = productService;
        this.cartService = cartService;
        this.orderService = orderService;
    }

    //ЗАКАЗ: создать
    @GetMapping("/order/create")
    public String orderCreate(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        int id_person = personDetails.getPerson().getId();

        List<Cart> cartList = cartService.findByPersonId(id_person);
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
        //добавить соли
        String uuid = UUID.randomUUID().toString();

        for (Product product: productList) {
            Order newOrder = new Order(uuid, product, personDetails.getPerson(), 1, product.getPrice(), Status.Принят);
            orderService.saveOrder(newOrder);

            //очистить корзину
            cartService.deleteItemFromCart(product.getId());
        }

        return "redirect:/orders";
    }

    //Пользователь: вывести все заказы
    @GetMapping("/orders")
    public String userOrder(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        List<Order> orderList = orderService.findOrderByPerson(personDetails.getPerson());
        int orderCount=0;
        for (Order order: orderList) {
            orderCount+=1;
        }
        model.addAttribute("userOrderCount", orderCount);
        model.addAttribute("userOrders", orderList);
        model.addAttribute("userAuth", personDetails.getPerson());
        return "user/orders";
    }

    //Пользователь: открыть список активных заказов
    @GetMapping("/user/order/active")
    public String userOrderActive(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        List<Order> orderActiveList = orderService.findOrderByStatusActive(personDetails.getPerson());
        int orderActiveCount=0;
        for (Order order: orderActiveList) {
            orderActiveCount+=1;
        }
        model.addAttribute("orderActiveCount", orderActiveCount);
        model.addAttribute("userOrderActive",orderActiveList);
        model.addAttribute("userAuth", personDetails.getPerson());
        return "user/order/orderActive";
    }

    //Пользователь: открыть список активных заказов
    @GetMapping("/user/order/history")
    public String userOrderHistory(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        List<Order> orderFinishList = orderService.findOrderByStatusHistory(personDetails.getPerson());
        int orderFinishCount=0;
        for (Order order: orderFinishList) {
            orderFinishCount+=1;
        }
        model.addAttribute("orderFinishCount", orderFinishCount);
        model.addAttribute("userOrderHistory", orderFinishList);
        model.addAttribute("userAuth", personDetails.getPerson());
        return "user/order/orderHistory";
    }

}
