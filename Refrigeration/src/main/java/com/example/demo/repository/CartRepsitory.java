package com.example.demo.repository;

import com.example.demo.model.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepsitory extends JpaRepository<Cart,Integer> {
}
