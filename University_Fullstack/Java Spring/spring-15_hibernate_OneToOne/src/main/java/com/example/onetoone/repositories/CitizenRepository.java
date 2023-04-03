package com.example.onetoone.repositories;

import com.example.onetoone.models.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {

    //поиск пользователя по фамилии
    Citizen findByLastName(String lastName);
}
