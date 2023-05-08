package com.example.market.repositories;

import com.example.market.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    //поиск без учена регистра по части наименования
    List<Product> findByTitleContainingIgnoreCase(String title);


    //ТОВАРЫ: поиск по наименованию в любой части строки и фильтр по цене
    @Query(value = "select * from product where ((lower(title) like %?1%) or (lower(title) like '?1%') or (lower(title) like '%?1')) and (price >= ?2 and price <=?3)", nativeQuery = true)
    List<Product> findByTitleAndPriceGreaterThanEqualAndPriceLessThanEqual(String title, float priceFrom, float priceTo);

    //ТОВАРЫ: найти по названию и сортировать по возрастанию
    @Query(value="select * from product where (lower(title) like %?1%) or (lower(title) like '?1%') or (lower(title) like '%?1') and (price >= ?2 and price <=?3) order by price"
            , nativeQuery = true)
    List<Product> findByTitleOrderByPriceAsc(String title, float priceFrom, float priceTo);

    //ТОВАРЫ: найти по названию и сортировать по убыванию
    @Query(value="select * from product where (lower(title) like %?1%) or (lower(title) like '?1%') or (lower(title) like '%?1') and (price >= ?2 and price <=?3) order by price desc"
            , nativeQuery = true)
    List<Product> findByTitleOrderByPriceDesc(String title, float priceFrom, float priceTo);


    //ТОВАРЫ: найти по названию и категории, сортировать по цене (возрастанию)
    @Query(value="select * from product where category_id =?4 and (lower(title) like %?1%) or (lower(title) like '?1%') or (lower(title) like '%?1') and (price >= ?2 and price <=?3) order by price"
            , nativeQuery = true)
    List<Product> findByTitleAndCategoryOrderByPriceAsc(String title, float priceFrom, float priceTo, int category);

    //ТОВАРЫ: найти по названию и категории, сортировать по цене (убыванию)
    @Query(value="select * from product where category_id =?4 and (lower(title) like %?1%) or (lower(title) like '?1%') or (lower(title) like '%?1') and (price >= ?2 and price <=?3) order by price desc"
            , nativeQuery = true)
    List<Product> findByTitleAndCategoryOrderByPriceDesc(String title, float priceFrom, float priceTo, int category);
}
