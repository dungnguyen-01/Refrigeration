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

    private String manufacturer;
    private double price;
    @Column(name = "image_f", columnDefinition = "LONGBLOB")
    /*@Lob
    private byte[] imageF;*/
    private String imageF;
    @Column(name = "image_s", columnDefinition = "LONGBLOB")
    private String imageS;
    @Column(name = "image_t", columnDefinition = "LONGBLOB")
    private String imageT;
    private int qty;
    private String description;
    @Column(name = "product_type")
    private int productType;

    @ManyToOne()
    @JoinColumn(name = "cate_id")
    Category category;


}
