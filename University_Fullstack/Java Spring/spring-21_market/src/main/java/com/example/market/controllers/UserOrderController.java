package com.example.market.controllers;

import com.example.market.enumm.Status;
import com.example.market.models.Order;
import com.example.market.security.PersonDetails;
import com.example.market.services.OrderService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserOrderController {
    private final OrderService orderService;

    public UserOrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    //Пользователь: вывести все заказы
    @GetMapping("/orders")
    public String userOrder(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        List<Order> orderList = orderService.findOrderByPerson(personDetails.getPerson());

        //List<Order> orderList = orderRepository.findByPerson(personDetails.getPerson());

        model.addAttribute("userOrders", orderList);
        model.addAttribute("userAuth", personDetails.getPerson());
        return "user/orders";
    }

    //Пользователь: открыть список активных заказов
    @GetMapping("/user/order/active")
    public String userOrderActive(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        model.addAttribute("userOrderActive", orderService.findOrderByStatusActive(personDetails.getPerson()));
        model.addAttribute("userAuth", personDetails.getPerson());
        return "user/order/orderActive";
    }

    //Пользователь: открыть список активных заказов
    @GetMapping("/user/order/history")
    public String userOrderHistory(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        model.addAttribute("userOrderHistory", orderService.findOrderByStatusHistory(personDetails.getPerson()));
        model.addAttribute("userAuth", personDetails.getPerson());
        return "user/order/orderHistory";
    }

}
