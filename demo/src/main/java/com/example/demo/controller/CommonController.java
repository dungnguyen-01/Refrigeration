package com.example.demo.controller;

import com.example.demo.repository.OrderRepsitory;
import com.example.demo.repository.AdminRepsitory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    @Autowired
    private OrderRepsitory dao;
    @Autowired
    private AdminRepsitory userd;

    @GetMapping("/add")
    public JSONObject addToCart(){
        JSONObject jsonObject = new JSONObject();
//        Order oder = new Order();
//        oder.setName("dung");
//        oder.setPhone("092378237");
//        oder.setEmail("dung@123");
//        oder.setAddress("tp_hcm");
//        oder.setDesc("good job");
//        oder.setStatus(1);

        return jsonObject;
    }

    @RequestMapping("/admin/index")
    public String  index() {
        return "/admin/index";
    }



    @RequestMapping("/admin/product")
    public String  adminPro() {
        return "/admin/product";
    }

    @RequestMapping("/admin/service")
    public String  adminSer() {
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

    @RequestMapping("client/product")
    public String  product() {
        return "client/product";
    }

    @RequestMapping("client/cart")
    public String  cart() {
        return "client/cart";
    }

    @RequestMapping("client/category")
    public String  category() {
        return "client/category";
    }

    @RequestMapping("client/contact")
    public String  contact() {
        return "client/contact";
    }

    @RequestMapping("client/detailService")
    public String  detailService() {
        return "client/detailService";
    }

    @RequestMapping("client/detailCate")
    public String  detailCate() {
        return "client/detailCate";
    }




}
