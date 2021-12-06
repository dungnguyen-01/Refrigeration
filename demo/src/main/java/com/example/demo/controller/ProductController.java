package com.example.demo.controller;

import com.example.demo.controller.body.ProductBody;
import com.example.demo.model.ProductModel;
import com.example.demo.model.entities.Product;
import com.example.demo.repository.CategoryRepsitory;
import com.example.demo.repository.ProductRepsitory;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductModel productModel;
    @Autowired
    private ProductRepsitory productRepsitory;

    @PostMapping("/admin/add")
    //@ResponseBody
    public String addProduct(@RequestParam("file") MultipartFile file, @RequestParam("price") double price,
                                @RequestParam("name") String name){

        productModel.addP(file, price, name);
        return "redirect:/admin/product";
    }

    @RequestMapping("/admin/product")
    public String adminPro(Model model) {
        List<Product> products = productRepsitory.findAll();
        model.addAttribute("listProduct",products);
        return "/admin/product";
    }
}
