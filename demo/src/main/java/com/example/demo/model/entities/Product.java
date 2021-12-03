package com.example.demo.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    @Column(name = "cateId")
    private int cateId;
    private double price;
    @Column(name = "imageId")
    private int imageId;
    private int qty;
    private String description;
    private boolean status;
}
