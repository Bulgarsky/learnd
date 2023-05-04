package com.example.market.services;

import com.example.market.models.Order;
import com.example.market.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //вернуть всех заказы ???
    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }
    //найти заказ по айди???
    public Order findById(int id){
        Optional<Order> order_db = orderRepository.findByPerson_Id(id);
        return order_db.orElse(null);
    }



}
