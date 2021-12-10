package com.example.demo.controller;


import com.example.demo.controller.body.AdminBody;
import com.example.demo.model.AdminModel;
import com.example.demo.model.OtpModel;
import com.example.demo.model.entities.Admin;
import com.example.demo.repository.AdminRepsitory;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
public class AdminController {
    @Autowired
    private AdminModel adminModel;
    @Autowired
    private OtpModel otpModel;
    @Autowired
    private AdminRepsitory adminRepsitory;


    @RequestMapping("admin/login")
    public String loginForm(){

        return "admin/login";
    }





    @PostMapping("/admin/login")
    public String login(Model model, @RequestParam("email") String email,
                        @RequestParam("password") String password){
            Admin admin = adminRepsitory.checkLogin(email, password);
            if (admin == null){
                model.addAttribute("message", "Sai email hoặc mật khẩu!");
                return "admin/login";
            }else {
                return "/admin/index";
            }
    }

    @RequestMapping("admin/forgot")
    public String requestForget(){
        return "admin/authen";
    }


    @ResponseBody
    @PostMapping("admin/sendOtp")
    public JSONObject sendOtp(){
        JSONObject jsonObject = new JSONObject();
        System.out.println(otpModel.sendOtp());
        jsonObject.put("msg",otpModel.sendOtp());

        return jsonObject;
    }

    @ResponseBody
    @PostMapping("admin/change-pass")
    public JSONObject changePass(@RequestBody AdminBody body){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("msg",adminModel.changePass(body));

        return jsonObject;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin")
    public String getAdmins(Model model, @RequestParam("page") Optional<Integer> page,
                            @RequestParam("size") Optional<Integer> size){

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<Admin> bookPage = adminModel.getAllAdmin(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("adminPage", bookPage);

        int totalPages = bookPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "admin/authen";
    }


}
