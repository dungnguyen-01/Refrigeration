package com.example.demo.controller.body;

import com.example.demo.model.entities.Category;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
public class ProductBody implements Serializable {
    private String image;
    private String name;
    private String manufacturer;
    private double price;
    private int qty;
    private String description;
    private int status;
    private Category category;
    //private MultipartFile imageF;
    private byte[] imageS;
    private byte[] imageT;
    private byte[] imageF;
}
