package com.example.demo.controller;

import com.example.demo.model.ServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class ServiceController {
    @Autowired
    private ServiceModel serviceModel;

    @PostMapping(value = "/addService")
    public String addService(@RequestParam("imageF") MultipartFile imageF,
                             @RequestParam("description") String description,
                             @RequestParam("name") String name){
        serviceModel.addService(imageF, name, description);
        return "admin/service";
    }
}
