package com.example.demo.model.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "otp")
public class OTP {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private int code;
    private int status;
    private Date created;
}
