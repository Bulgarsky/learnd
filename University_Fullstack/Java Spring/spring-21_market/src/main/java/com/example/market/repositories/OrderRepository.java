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

    List<Order> findByPerson(Person person);

    //поиск по уникальному номеру заказа ???
    Optional<Order> findByOrderNo(String OrderNo);


}
