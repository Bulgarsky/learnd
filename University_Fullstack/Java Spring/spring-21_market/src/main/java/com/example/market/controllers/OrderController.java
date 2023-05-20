package com.example.market.controllers;

import com.example.market.enumm.Status;
import com.example.market.models.Cart;
import com.example.market.models.Order;
import com.example.market.models.Product;
import com.example.market.security.PersonDetails;
import com.example.market.services.CartService;
import com.example.market.services.OrderService;
import com.example.market.services.ProductService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class OrderController {
    private final ProductService productService;
    private final CartService cartService;
    private final OrderService orderService;

    public OrderController(ProductService productService, CartService cartService, OrderService orderService) {
        this.productService = productService;
        this.cartService = cartService;
        this.orderService = orderService;
    }
}
