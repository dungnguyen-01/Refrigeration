package com.example.demo.model;

import com.example.demo.repository.ServiceRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
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
            String fileName= StringUtils.cleanPath(image.getOriginalFilename());
            service.setNameImage(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        service.setName(name);
        serviceRepsitory.save(service);
    }

    public void editService(MultipartFile image, String name, String des, Integer id){
        com.example.demo.model.entities.Service service = serviceRepsitory.getById(id);
        service.setName(name);
        service.setDescription(des);
        try {
            if(!image.isEmpty() || image.getSize()>0)
                service.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
                String fileName= StringUtils.cleanPath(image.getOriginalFilename());
                service.setNameImage(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        serviceRepsitory.save(service);
    }
}
