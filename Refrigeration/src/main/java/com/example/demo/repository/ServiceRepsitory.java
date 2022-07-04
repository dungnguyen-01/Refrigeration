package com.example.demo.repository;

import com.example.demo.model.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepsitory extends JpaRepository<Service,Integer> {
}
