package com.example.demo.repository;

import com.example.demo.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepsitory extends JpaRepository<Category,Integer> {
}
