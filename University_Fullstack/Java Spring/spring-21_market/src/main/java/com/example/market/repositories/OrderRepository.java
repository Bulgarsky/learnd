package com.example.market.repositories;

import com.example.market.models.Order;
import com.example.market.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    //найти заказы по id пользователя ??
    @Query(value="select * from order_list where person_id = ?1", nativeQuery = true)
    List<Order> findByPerson_Id(int id);

    //найти заказы по пользователю
    List<Order> findByPerson(Person person);

    //найти заказы по номеру заказа
    List<Order> findByOrderNoContainingIgnoreCase(String orderNo);


    //найти заказ по номеру заказа и по id пользователя
    @Query(value="select * from order_list where person_id = ?1 and orderNo = ?2", nativeQuery = true)
    List<Order> findByPerson_IdAndAndOrderNo(int personId, String orderNo);


    //История заказов: отобрать все заказы пользователя с принятым статусом
    @Query(value="select * from order_list where person_id = ?1 and status= ?2", nativeQuery = true)
    List<Order> findByPersonAndStatus(int personId, String statusReceived);

    Order findOrderById(int id);

}
