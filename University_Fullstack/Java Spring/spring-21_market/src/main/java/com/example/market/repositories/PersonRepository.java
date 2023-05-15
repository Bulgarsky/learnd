package com.example.market.repositories;

import com.example.market.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository  extends JpaRepository <Person, Integer>{

    //найти пользователя по логину
    Optional<Person> findByLogin(String login);

    //найти пользователей по части логина
    Optional<Person> findByLoginContainingIgnoreCase(String login);

}
