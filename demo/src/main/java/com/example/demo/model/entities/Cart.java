package com.example.demo.model.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cart")
public class Cart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private int prodId;
    private  int qty;
    private double total;
}
