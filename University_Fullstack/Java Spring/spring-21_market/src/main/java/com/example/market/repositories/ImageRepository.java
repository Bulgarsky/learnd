package com.example.market.repositories;

import com.example.market.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Integer> {
List<Image> findAllByProduct_Id(int id);
}
