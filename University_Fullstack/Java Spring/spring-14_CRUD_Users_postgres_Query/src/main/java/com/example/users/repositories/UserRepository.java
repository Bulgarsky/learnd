package com.example.users.repositories;

import com.example.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //получение пользователя по емейлу
    //select * from user_site where email = {email}
    List<User> findByEmail(String email);

    //поиск по номеру телефона
    //select * from user_site where phone_no = {phoneNo}
    List<User> findByPhoneNo(String phoneNo);

    //поиск по фамилии, сортировка по возрасту
    //select * from user_site where last_name = {lastName} order by age;
    List<User> findByLastNameOrderByAge(String LastName);

    //Поиск фамилии со стартовой позиции по части строки
    //select * from user_site where last_name like '{startingWith}%'
    List<User> findByLastNameStartingWith(String startingWith);


    //Custom Query
    @Query(value = "select * from user_site where user_site .last_name = ?1 order by age desc", nativeQuery = true)
    List<User> findByLastNameOrderByAgeDesc(String lastName);
}
