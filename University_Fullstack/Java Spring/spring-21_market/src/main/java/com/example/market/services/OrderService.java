package com.example.market.services;

import com.example.market.models.Order;
import com.example.market.models.Person;
import com.example.market.repositories.OrderRepository;
import com.example.market.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.market.enumm.Status;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //ЗАКАЗЫ: вернуть все заказы для админа (работает)
    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }

    //ЗАКАЗЫ: найти заказы по id пользователя (работает)
    public List<Order> findByPersonId (int id){
        return orderRepository.findByPerson_Id(id);
    }

    //ЗАКАЗЫ: найти заказ по номеру заказа для админа (работает)
    public List<Order> findOrderByOrderNo(String orderNo){
        List<Order> optionalOrder = orderRepository.findByOrderNoContainingIgnoreCase(orderNo);
        return optionalOrder;
    }

    //ЗАКАЗЫ: получить заказ по id
    public Order findByOrderId(int id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }

    //Заказ: создать заказ
    public void saveOrder(Order order){
       orderRepository.save(order);
    }

    //ТОВАРЫ: найти товары по пользователю
    public List<Order> findOrderByPerson(Person person){
        List<Order> optionalOrder = orderRepository.findByPerson(person);
        return optionalOrder;
    }

    //ЗАКАЗЫ: обновить заказ (работает)
    public void orderStatusUpdate(int id, Order order, Status newStatus){

        Order orderUpdate = findByOrderId(id);
        orderUpdate.setOrderNo(order.getOrderNo());
        orderUpdate.setCount(order.getCount());
        orderUpdate.setProduct(order.getProduct());
        orderUpdate.setDateTime(order.getDateTime());
        orderUpdate.setPerson(order.getPerson());
        orderUpdate.setPrice(order.getPrice());
        orderUpdate.setStatus(newStatus);
        orderRepository.save(orderUpdate);
    }

    //Заказы: отобрать активные заказы пользователя (все кроме статусов: Получен, Отменен)
    public List<Order> findOrderByStatusActive(Person person){
        //получаем список всех заказов
        List<Order> personOrderList = orderRepository.findByPerson(person);
        //создаем лист активных заказов
        List<Order> personOrderActive = new ArrayList<>();
        List<Order> personOrderHistory = new ArrayList<>();
        //перебираем все заказы, нужные кладем в список активных заказов
        for (Order orderItem: personOrderList){
            if (!orderItem.getStatus().toString().equalsIgnoreCase("Получен")
              && !orderItem.getStatus().toString().equalsIgnoreCase("Отменён")
            ){
                System.out.println("Status: "+ orderItem.getStatus());
                personOrderActive.add(orderRepository.findOrderById(orderItem.getId()));
            }
        }
        return personOrderActive;
    }

    //Заказы: составить историю заказов (статусы: получен, отменен)
    public List<Order> findOrderByStatusHistory(Person person){
        //получаем список всех заказов
        List<Order> personOrderList = orderRepository.findByPerson(person);
        //создаем лист активных заказов
        List<Order> personOrderHistory = new ArrayList<>();
        //перебираем все заказы, нужные кладем в список активных заказов
        for (Order orderItem: personOrderList){
            if (!orderItem.getStatus().toString().equalsIgnoreCase("Принят")
                    && !orderItem.getStatus().toString().equalsIgnoreCase("Оформлен")
                    && !orderItem.getStatus().toString().equalsIgnoreCase("Ожидает")
            ){
                System.out.println("Status: "+ orderItem.getStatus());
                personOrderHistory.add(orderRepository.findOrderById(orderItem.getId()));
            }
        }
        return personOrderHistory;
    }


}
