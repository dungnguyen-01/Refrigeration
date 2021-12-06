package com.example.demo.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    @Column(name = "cate_id")
    private int cateId;
    private String trademark;
    private double price;
    @Column(name = "image_f", columnDefinition = "MEDIUMBLOB")
    /*@Lob
    private byte[] imageF;*/
    private String imageF;
    @Column(name = "image_s")
    private Byte[] imageS;
    @Column(name = "image_t")
    private Byte[] imageT;
    private int qty;
    private String description;
    private boolean status;
    private String image;
}
