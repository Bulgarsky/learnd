package com.example.market.services;

import com.example.market.models.Order;
import com.example.market.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import com.example.market.enumm.Status;

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

    //найти заказ по номеру заказа (не использован)
       public List<Order> findOrderByOrderNo(String orderNo){
        List<Order> optionalOrder = orderRepository.findByOrderNoContainingIgnoreCase(orderNo);
        return optionalOrder;
    }

    //обновить заказ (не работает)

    public void updateOrder(int id, String newStatus, Order order){

        Order orderUpdate = findByOrderId(id);
        orderUpdate.setOrderNo(order.getOrderNo());
        orderUpdate.setId(order.getId());
        orderUpdate.setCount(order.getCount());
        orderUpdate.setProduct(order.getProduct());
        orderUpdate.setDateTime(order.getDateTime());
        orderUpdate.setPerson(order.getPerson());
        orderUpdate.setPrice(order.getPrice());
        orderUpdate.setStatus(Status.valueOf(newStatus));

        orderRepository.save(order);
    }

    //получить заказ по id
    public Order findByOrderId(int id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }

}
