package com.example.demo.controller;

import com.example.demo.controller.body.ProductBody;
import com.example.demo.model.ProductModel;
import com.example.demo.model.entities.Category;
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
    @Autowired
    private CategoryRepsitory categoryRepsitory;

    @PostMapping("/admin/add")
    //@ResponseBody
    public String addProduct(@RequestParam("imageF") List<MultipartFile> imageF, @RequestParam("price") double price,
                             @RequestParam("name") String name,
                             @RequestParam("cateId") int cateId,
                             @RequestParam("qty") int qty,
                             @RequestParam("description") String description
                             ){

        productModel.addP(imageF, price, name,cateId,qty,description);
        return "redirect:/admin/product";
    }

    @RequestMapping("/admin/product")
    public String adminPro(Model model) {
        List<Category> listCategory = categoryRepsitory.findAll();
        model.addAttribute("listCategory",listCategory);

        List<Product> products = productRepsitory.findAll();
        model.addAttribute("listProduct",products);
        return "/admin/product";
    }

    @RequestMapping("/admin/delete/{id}")
    public String deletePro(@PathVariable("id")Integer id) {
        productRepsitory.deleteById(id);
        return "redirect:/admin/product";
    }

    @RequestMapping("/admin/edit/{id}")
    public String editPro(Model model,@PathVariable("id")Integer id) {
        Product product = productRepsitory.getById(id);
        model.addAttribute("product",product);

        List<Category> listCategory = categoryRepsitory.findAll();
        model.addAttribute("listCategory",listCategory);
        return "/admin/editProd";
    }

}
