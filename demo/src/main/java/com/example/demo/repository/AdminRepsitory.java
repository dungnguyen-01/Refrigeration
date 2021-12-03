package com.example.demo.repository;

import com.example.demo.model.entities.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//@Repository
public interface AdminRepsitory extends JpaRepository<Admin, Integer> {
    Admin findFirstByName(String name);
    List<Admin> findAllByName(String name);

    @Query("SELECT a FROM Admin a "
            + " WHERE a.email LIKE ?1 "
            + " and a.password LIKE ?2 ")
    Admin checkLogin(String email,String password);


}
