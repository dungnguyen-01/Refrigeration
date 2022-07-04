package com.example.demo.model;

import com.example.demo.controller.body.ProductBody;
import com.example.demo.model.entities.Category;
import com.example.demo.model.entities.Product;
import com.example.demo.repository.CategoryRepsitory;
import com.example.demo.repository.ProductRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ProductModel {
    @Autowired
    private ProductRepsitory productRepsitory;

    public void addP(List<MultipartFile> imageF, long price,int productType, String name, String manufacturer, Category category, int qty, String description){
        Product p = new Product();
        p.setName(name);
        p.setCategory(category);
        p.setManufacturer(manufacturer);
        p.setQty(qty);
        p.setPrice(price);
        p.setProductType(productType);
        p.setDescription(description);
        //String fileName= StringUtils.cleanPath(imageF.getOriginalFilename());

        try {
            if(imageF.size()>0){
                p.setImageF(Base64.getEncoder().encodeToString(imageF.get(0).getBytes()));
                String fileName= StringUtils.cleanPath(imageF.get(0).getOriginalFilename());
                p.setNameImageF(fileName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if(imageF.size()>1 && imageF.get(1)!= null){
            try {
                p.setImageS(Base64.getEncoder().encodeToString(imageF.get(1).getBytes()));
                String fileName= StringUtils.cleanPath(imageF.get(1).getOriginalFilename());
                p.setNameImageS(fileName);
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        if(imageF.size()>2 && imageF.get(2)!= null){
            try {
                p.setImageT(Base64.getEncoder().encodeToString(imageF.get(2).getBytes()));
                String fileName= StringUtils.cleanPath(imageF.get(2).getOriginalFilename());
                p.setNameImageT(fileName);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        productRepsitory.save(p);
    }

}
