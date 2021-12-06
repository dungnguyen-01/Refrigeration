package com.example.demo.model;

import com.example.demo.controller.body.ProductBody;
import com.example.demo.model.entities.Product;
import com.example.demo.repository.CategoryRepsitory;
import com.example.demo.repository.ProductRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class ProductModel {
    @Autowired
    private ProductRepsitory productRepsitory;

    public void addP(MultipartFile file, double price, String name){
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
        try {
            p.setImageF(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        productRepsitory.save(p);
    }

    public String addProduct(ProductBody body){
        try {
            Product product = new Product();
            product.setName(body.getName());
            product.setCateId(body.getCategory());
            product.setDescription(body.getDescription());
            product.setPrice(body.getPrice());
            product.setImage(body.getImage());
            //product.setImageF(body.getImageF().getBytes());
            product.setQty(body.getQty());

            productRepsitory.save(product);
            return "Thêm sản phẩm thành công";
        } catch (Exception e){
            return "Có lỗi xảy ra !";
        }
    }
}
