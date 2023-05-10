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

    //поиск по части названия и сорт по цене
    //По возрастанию
    @Query(value = "select * from product where ((lower(title) like %?1%) or (lower(title) like '?1%') or (lower(title) like '%?1')) order by price asc", nativeQuery = true)
    List<Product> findByTitleContainingIgnoreCaseOrderByPriceAsc(String title);
    //по убыванию
    @Query(value = "select * from product where ((lower(title) like %?1%) or (lower(title) like '?1%') or (lower(title) like '%?1')) order by price desc", nativeQuery = true)
    List<Product> findByTitleContainingIgnoreCaseOrderByPriceDesc(String title);

    //найти по части названия, категории, сортировать по цене
    //по возрастанию
    @Query(value = "select * from product where ((lower(title) like %?1%) or (lower(title) like '?1%') or (lower(title) like '%?1')) and category_id = ?2 order by price asc", nativeQuery = true)
    List<Product> findByTitleContainingIgnoreCaseAndCategoryOrderByPriceAsc(String title, int category);
    //по убыванию
    @Query(value = "select * from product where category_id = ?2 and ((lower(title) like %?1%) or (lower(title) like '?1%')) or (lower(title) like '%?1') order by price desc", nativeQuery = true)
    List<Product> findByTitleContainingIgnoreCaseAndCategoryOrderByPriceDesc(String title, int category);


    //ТОВАРЫ: поиск по части названия, цене "от и до"
    @Query(value = "select * from product where ((lower(title) like %?1%) or (lower(title) like '?1%') or (lower(title) like '%?1')) and (price >= ?2 and price <=?3)", nativeQuery = true)
    List<Product> findByTitleAndPriceGreaterThanEqualAndPriceLessThanEqual(String title, float priceFrom, float priceTo);

    //найти по части названия, цене "от и до" и сортировать
    //Без категории
    // (по возрастанию)
    @Query(value="select * from product where (lower(title) like %?1%) or (lower(title) like '?1%') or (lower(title) like '%?1') and (price >= ?2 and price <=?3) order by price asc"
            , nativeQuery = true)
    List<Product> findByTitleOrderByPriceAsc(String title, float priceFrom, float priceTo);
    // по убыванию
    @Query(value="select * from product where ((lower(title) like %?1%) or (lower(title) like '?1%') or (lower(title) like '%?1')) and (price >= ?2 and price <=?3) order by price desc"
            , nativeQuery = true)
    List<Product> findByTitleOrderByPriceDesc(String title, float priceFrom, float priceTo);

    //3
    //найти по части названия, цене "от и до", категории, сортировать по цене
    // (возрастанию)
    @Query(value="select * from product where category_id =?4 and ((lower(title) like %?1%) or (lower(title) like '?1%') or (lower(title) like '%?1')) and (price >= ?2 and price <=?3) order by price"
            , nativeQuery = true)
    List<Product> findByTitleAndCategoryOrderByPriceAsc(String title, float priceFrom, float priceTo, int category);
    //(убыванию)
    @Query(value="select * from product where category_id =?4 and (lower(title) like %?1%) or (lower(title) like '?1%') or (lower(title) like '%?1') and (price >= ?2 and price <=?3) order by price desc"
            , nativeQuery = true)
    List<Product> findByTitleAndCategoryOrderByPriceDesc(String title, float priceFrom, float priceTo, int category);

    //1
    //Найти  по категории и отсортировать цену
    //(по возрастанию)
    @Query(value = "select * from product where category_id =?1 order by price asc", nativeQuery = true)
    List<Product> findByCategoryAndOrderByPriceAsc(int category);
    //(по убыванию)
    @Query(value = "select * from product where category_id = ?1 order by price desc", nativeQuery = true)
    List<Product> findByCategoryAndOrderByPriceDesc(int category);

    //1
    //Найти все товары, цена "от и до", без категории, отсортировать по цене
    // (по возрастанию)
    @Query(value = "select * from product where (price >= ?1 and price <=?2) order by price asc", nativeQuery = true)
    List<Product> findAllLookingPriceAndOrderByPriceAsc(float priceFrom, float priceTo);
    //По убыванию
    @Query(value = "select * from product where (price >= ?1 and price <=?2) order by price asc", nativeQuery = true)
    List<Product> findAllLookingPriceAndOrderByPriceDesc(float priceFrom, float priceTo);


    //Найти все товары, без категории отсортировать цену
    // по убыванию
    @Query(value = "select * from product order by price desc", nativeQuery = true)
    List<Product> findAllAndOrderByPriceDesc();
    //по возрастанию
    @Query(value = "select * from product order by price asc", nativeQuery = true)
    List<Product> findAllAndOrderByPriceAsc();


    //2
    //Найти все товары, цена "от и до", с категорией, сортировать
    //по возрастанию
    @Query(value = "select * from product where (categoty_id = ?3) and (price >= ?1 and price <=?2) order by price asc", nativeQuery = true)
    List<Product> findProductByPriceBetweenAndOrderByPriceAsc(float priceFrom, float priceTo, int category);
    //по убыванию
    @Query(value = "select * from product where (categoty_id = ?3) and (price >= ?1 and price <=?2) order by price desc", nativeQuery = true)
    List<Product> findProductByPriceBetweenAndOrderByPriceDesc(float priceFrom, float priceTo, int category);


}
