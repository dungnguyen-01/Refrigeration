package com.example.demo.controller;

import com.example.demo.model.entities.Service;
import com.example.demo.repository.OrderRepsitory;
import com.example.demo.repository.AdminRepsitory;
import com.example.demo.repository.ProductRepsitory;
import com.example.demo.repository.ServiceRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CommonController {

    @Autowired
    private OrderRepsitory dao;
    @Autowired
    private AdminRepsitory userd;
    @Autowired
    private ProductRepsitory productRepsitory;
    @Autowired
    private ServiceRepsitory serviceRepsitory;

    @RequestMapping("/admin/index")
    public String  index() {
        return "/admin/index";
    }


    @RequestMapping("/admin/service")
    public String adminSer(Model model) {
        List<Service> list = serviceRepsitory.findAll();
        model.addAttribute("list",list);
        return "/admin/service";
    }

    @RequestMapping("/admin/orderDetail")
    public String  adminOr() {
        return "/admin/orderDetail";
    }

    @RequestMapping("client/index")
    public String  clinet() {
        return "client/index";
    }

    @RequestMapping("client/categoryOld")
    public String  cateOld() {
        return "client/categoryOld";
    }

//    @RequestMapping("client/product")
//    public String  product() {
//        return "client/product";
//    }

    @RequestMapping("client/cart")
    public String  cart() {
        return "client/cart";
    }

//    @RequestMapping("client/category")
//    public String  category() {
//        return "product";
//    }

    @RequestMapping("client/contact")
    public String  contact() {
        return "client/contact";
    }

    @RequestMapping("client/detailService")
    public String  detailService() {
        return "client/detailService";
    }






}
