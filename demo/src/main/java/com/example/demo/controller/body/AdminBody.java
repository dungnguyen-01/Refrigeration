package com.example.demo.controller.body;

import lombok.Data;

@Data
public class AdminBody {
    private String pass;
    private String repass;
    private int otp;
}
