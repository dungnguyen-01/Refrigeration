package com.example.demo.repository;

import com.example.demo.controller.body.ProductBody;
import com.example.demo.model.entities.Category;
import com.example.demo.model.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepsitory extends JpaRepository<Product,Integer> {

//    @Query(value="SELECT p.name, p.manufacturer,p.price, p.qty, p.description,p.imageF,p.imageS ,p.imageT ,p.status , c.name" +
//            " FROM Product p" +
//            " INNER JOIN Category c " +
//            "ON p.cateId = c.id")
//    List<ProductBody> findJoin();

    @Query("SELECT p FROM Product p " +
            " WHERE p.productType = 0 ")
    Page<Product> findByProductProductTypeOld(PageRequest of);

    @Query("SELECT p FROM Product p " +
            " WHERE p.productType = 1 ")
    Page<Product> findByProductProductTypeNew(PageRequest of);


    @Query("SELECT p FROM Product p " +
            " WHERE p.category = ?1 and p.productType=0")
    Page<Product> findByProductCateId(Category category, PageRequest of);



    @Query("SELECT p FROM Product p" +
            " WHERE p.name LIKE %?1% " +
            "OR p.category.name LIKE %?1%" +
            "OR p.manufacturer LIKE %?1%")
    List<Product> findByKeyword(String name);


}
