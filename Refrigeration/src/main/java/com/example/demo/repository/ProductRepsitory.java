package com.example.demo.repository;

import com.example.demo.model.entities.Category;
import com.example.demo.model.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepsitory extends JpaRepository<Product,Integer> {

//    Danh cho product old
    @Query(value= "SELECT * FROM  product WHERE product_type= 0 ORDER by id DESC LIMIT 0,1", nativeQuery=true)
    List<Product> findByProductTop1Old();

    @Query("SELECT p FROM Product p " +
            " WHERE p.category.id like ?1 and p.productType= 0")
    Page<Product> findCategory(Integer ids, PageRequest of);

    @Query("SELECT p FROM Product p " +
            " WHERE p.productType = 0 ")
    Page<Product> findByProductProductTypeOld(PageRequest of);

    @Query("SELECT p FROM Product p" +
            " WHERE p.productType = 0 and" +
            " p.name LIKE %?1% " +
            "OR p.category.name LIKE %?1%" +
            "OR p.manufacturer LIKE %?1%")
    Page<Product> findByKeyword(String name, PageRequest of);

    @Query(value = "SELECT p FROM Product p WHERE (p.name LIKE %?1% OR p.category.name LIKE %?1% OR p.manufacturer LIKE %?1%) " +
            "AND p.productType= 0 and " +
            "p.category.id like ?2")
    Page<Product> findByKeywordAndCate(String keyword, Integer cateid, PageRequest of);


// danh cho product new

    @Query(value= "SELECT * FROM product WHERE product_type= 1 ORDER by id DESC LIMIT 0,1", nativeQuery=true)
    List<Product> findByProductTop1New();

    @Query("SELECT p FROM Product p " +
            " WHERE p.category.id like ?1 and p.productType= 1")
    Page<Product>findCategoryNew(Integer ids, PageRequest of);

    @Query("SELECT p FROM Product p " +
            " WHERE p.productType = 1 ")
    Page<Product> findByProductProductTypeNew(PageRequest of);

    @Query("SELECT p FROM Product p" +
            " WHERE  p.productType = 1 and" +
            " p.name LIKE %?1% " +
            "OR p.category.name LIKE %?1%" +
            "OR p.manufacturer LIKE %?1%")
    Page<Product>findByKeywordNew(String name, PageRequest of);

    @Query(value = "SELECT p FROM Product p WHERE (p.name LIKE %?1% OR p.category.name LIKE %?1% OR p.manufacturer LIKE %?1%) " +
            "AND p.productType=1 and " +
            "p.category.id like ?2")
    Page<Product> findByKeywordAndCateNew(String keyword, Integer cateid, PageRequest of);


// danh cho thong ke so lieu
    @Query("SELECT SUM (p.qty) FROM Product p WHERE p.productType = 1")
     Integer findByCountProductTypeNew();
    @Query("SELECT SUM (p.qty *p.price) FROM Product p WHERE p.productType = 1")
    Integer findByCountProductTypeNewTotal();

    @Query("SELECT SUM (p.qty) FROM Product p WHERE p.productType = 0")
    Integer findByCountProductTypeOld();
    @Query("SELECT SUM (p.qty *p.price) FROM Product p WHERE p.productType = 0")
    Integer findByCountProductTypeOldTotal();

    @Query("SELECT SUM (p.qty) FROM Product p ")
    Integer findByCountProductType();

    @Query("SELECT SUM (p.qty *p.price) FROM Product p ")
    Integer findByCountProductTotal();




    @Query(value= "SELECT * FROM product LIMIT 0,15", nativeQuery=true)
    List<Product> findTopProduct();



}
