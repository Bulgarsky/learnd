package com.example.market.services;

import com.example.market.models.Order;
import com.example.market.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //вернуть всех заказы для админа (работает)
    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }

    //найти заказы по id пользователя (работает)
    public List<Order> findByPersonId (int id){
        return orderRepository.findByPerson_Id(id);
    }

    //получить заказ по id
    public Order findByOrderId(int id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }
    //обновить заказ
    @Transactional
    public void updateOrder(int id, Order order){
        order.setId(id);
        orderRepository.save(order);
    }


}
