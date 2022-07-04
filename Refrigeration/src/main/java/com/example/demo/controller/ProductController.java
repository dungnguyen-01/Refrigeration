package com.example.demo.controller;

import com.example.demo.model.ProductModel;
import com.example.demo.model.entities.Category;
import com.example.demo.model.entities.Product;
import com.example.demo.repository.CategoryRepsitory;
import com.example.demo.repository.ProductRepsitory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductModel productModel;
    @Autowired
    private ProductRepsitory productRepsitory;
    @Autowired
    private CategoryRepsitory categoryRepsitory;

    @RequestMapping("/admin/addProd")
    //@ResponseBody
    public String addProductForm(Model model){
        List<Category> listCategory = categoryRepsitory.findAll();
        model.addAttribute("listCategory",listCategory);

        return "/admin/addProd";
    }

    @PostMapping("/admin/add")
    //@ResponseBody
    public String addProduct(@RequestParam("imageF") List<MultipartFile> imageF, @RequestParam("price") long price,
                             @RequestParam("name") String name,
                             @RequestParam("manufacturer") String manufacturer,
                             @RequestParam("category") Category category,
                             @RequestParam("qty") int qty,
                             @RequestParam("productType") int productType,
                             @RequestParam("description") String description){


        productModel.addP(imageF,price,productType,name,manufacturer,category,qty,description);
        return "redirect:/admin/product";
    }

    @RequestMapping("/admin/product")
    public String adminPro(Model model) {
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
        model.addAttribute("form",product);

        List<Category> listCategory = categoryRepsitory.findAll();
        model.addAttribute("listCategory",listCategory);
        return "/admin/editProd";
    }

    @PostMapping("/admin/updated")
    public String editProduct(@RequestParam("imageF") List<MultipartFile> imageF, @RequestParam("price") long price,
                              @RequestParam("name") String name,
                              @RequestParam("category") Category category,
                              @RequestParam("manufacturer") String manufacturer,
                              @RequestParam("productType") int productType,
                              @RequestParam("qty") int qty, @RequestParam("id") int id,
                              @RequestParam("description") String description){
        Product product= productRepsitory.getById(id);
        product.setCategory(category);
        product.setPrice(price);
        product.setManufacturer(manufacturer);
        product.setQty(qty);
        product.setProductType(productType);
        product.setDescription(description);
        product.setName(name);

        if(imageF.size()>0 && imageF.get(0).getSize()>0){
            try {
                System.out.printf("Vào case1");
                product.setImageF(Base64.getEncoder().encodeToString(imageF.get(0).getBytes()));
                String fileName= StringUtils.cleanPath(imageF.get(0).getOriginalFilename());
                product.setNameImageF(fileName);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if(imageF.size()>0 && imageF.get(1).getSize()>0){
            try {

                System.out.println("Vào case2");
                product.setImageS(Base64.getEncoder().encodeToString(imageF.get(1).getBytes()));
                String fileName= StringUtils.cleanPath(imageF.get(1).getOriginalFilename());
                product.setNameImageS(fileName);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if(imageF.size()>0 && imageF.get(2).getSize()>0){
            try {
                //Log.info("Vào case3");
                product.setImageT(Base64.getEncoder().encodeToString(imageF.get(2).getBytes()));
                String fileName= StringUtils.cleanPath(imageF.get(2).getOriginalFilename());
                product.setNameImageT(fileName);
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        productRepsitory.save(product);
        return "redirect:/admin/product";
    }


    @RequestMapping("/admin/index")
    public  String index(Model model) {
        model.addAttribute("countNew",productRepsitory.findByCountProductTypeNew());
        model.addAttribute("countOld",productRepsitory.findByCountProductTypeOld());
        model.addAttribute("countAll",productRepsitory.findByCountProductType());

        model.addAttribute("totalNew",productRepsitory.findByCountProductTypeNewTotal());
        model.addAttribute("totalOld",productRepsitory.findByCountProductTypeOldTotal());
        model.addAttribute("total",productRepsitory.findByCountProductTotal());

        return "/admin/index";

    }


}
