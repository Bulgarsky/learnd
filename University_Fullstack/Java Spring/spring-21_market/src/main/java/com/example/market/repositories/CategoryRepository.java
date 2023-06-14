package com.example.market.repositories;

import com.example.market.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    //Category findByTitle(String title);

    //Category findById(int id);

    @Query(value = "select * from category where is_enabled=true order by id asc", nativeQuery = true)
    List<Category> findEnabled();
}
