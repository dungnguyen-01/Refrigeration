package com.example.demo.controller;


import com.example.demo.model.entities.Product;
import com.example.demo.repository.ProductRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientContoller {

    @Autowired
    ProductRepsitory productRepsitory;

    @RequestMapping("client/product")
    public String listCategory(Model model){
        model.addAttribute("listProduct",productRepsitory.findAll());
        return "client/product";
    }

    @RequestMapping("/client/detailProd/{id}")
    public String  detailCate(Model model, @PathVariable("id")Integer id) {
        model.addAttribute("product",productRepsitory.getById(id));
        return "/client/detailProd";
    }

}
