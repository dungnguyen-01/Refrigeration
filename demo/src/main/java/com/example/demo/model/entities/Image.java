package com.example.demo.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "image")
public class Image {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String link;
}
