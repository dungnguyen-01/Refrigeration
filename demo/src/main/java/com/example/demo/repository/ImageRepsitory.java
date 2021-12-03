package com.example.demo.repository;

import com.example.demo.model.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepsitory extends JpaRepository<Image,Integer> {
}
