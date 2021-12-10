package com.example.demo.repository;

import com.example.demo.controller.body.ProductBody;
import com.example.demo.model.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepsitory extends JpaRepository<Product,Integer> {

//    @Query(value="SELECT p.name, p.manufacturer,p.price, p.qty, p.description,p.imageF,p.imageS ,p.imageT ,p.status , c.name" +
//            " FROM Product p" +
//            " INNER JOIN Category c " +
//            "ON p.cateId = c.id")
//    List<ProductBody> findJoin();

}
