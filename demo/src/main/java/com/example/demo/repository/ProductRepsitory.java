package com.example.demo.repository;

import com.example.demo.model.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepsitory extends JpaRepository<Product,Integer> {
}
