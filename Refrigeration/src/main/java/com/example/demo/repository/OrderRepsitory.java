package com.example.demo.repository;

import com.example.demo.model.entities.Oderdetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepsitory extends JpaRepository<Oderdetail,Integer> {

}
