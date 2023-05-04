package com.example.market.repositories;

import com.example.market.models.Order;
import com.example.market.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findByPerson_Id(int id);
    List<Order> findByPerson(Person person);

    //поиск по номеру заказа ???
    List<Order> findByOrderNoContainingIgnoreCase(String orderNo);
}
