package com.example.demo.model;

import com.example.demo.repository.ServiceRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class ServiceModel {
    @Autowired
    private ServiceRepsitory serviceRepsitory;

    public void addService(MultipartFile image, String name, String des){
        com.example.demo.model.entities.Service service = new com.example.demo.model.entities.Service();
        service.setDescription(des);
        try {
            service.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        service.setName(name);
        serviceRepsitory.save(service);
    }
}
