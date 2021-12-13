package com.example.demo.controller;


import com.example.demo.model.entities.Category;
import com.example.demo.repository.CategoryRepsitory;
import com.example.demo.repository.ProductRepsitory;
import com.example.demo.repository.ServiceRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ClientContoller {

    @Autowired
    ProductRepsitory productRepsitory;

    @Autowired
    ServiceRepsitory serviceRepsitory;
    @Autowired
    CategoryRepsitory categoryRepsitory;


    @RequestMapping("/client/detailProd/{id}")
    public String  detailCate(Model model, @PathVariable("id")Integer id) {
        model.addAttribute("product",productRepsitory.getById(id));
        return "/client/detailProd";
    }

    @RequestMapping("client/service")
    public String listService(Model model){
        model.addAttribute("listService",serviceRepsitory.findAll());
        return "client/service";
    }


    @RequestMapping("/client/detailService/{id}")
    public String  productByCategory(Model model, @PathVariable("id")Integer id) {
        model.addAttribute("listService",serviceRepsitory.findAll());
        model.addAttribute("service",serviceRepsitory.getById(id));
        return "/client/detailService";
    }

    @RequestMapping("/client/product")
    public String productNew(HttpServletRequest request, Model model) {
        int page = 0;
        int size = 6;
        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }
        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }
        model.addAttribute("listCategory",categoryRepsitory.findAll());
        model.addAttribute("listProduct", productRepsitory.findByProductProductTypeNew(PageRequest.of(page, size)));

        return "client/product";
    }

    @RequestMapping("/client/productOld/{id}")
    public String  detailService(HttpServletRequest request,Model model, @PathVariable("id") Category id) {
        int page = 0;
        int size = 4;
        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }
        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }

        model.addAttribute("listCategory",categoryRepsitory.findAll());
        model.addAttribute("listProduct", productRepsitory.findByProductCateId(id,PageRequest.of(page, size)));
        return "/client/productOld";
    }

    @PostMapping ("/client/productOld")
    public String  searchProduct(HttpServletRequest request,Model model, @RequestParam("keyword") String keywrod) {

        model.addAttribute("listCategory", categoryRepsitory.findAll());
        model.addAttribute("listProduct", productRepsitory.findByKeyword(keywrod));

        return "/client/productOld";
    }

    @RequestMapping("/client/productOld")
    public String productOld(HttpServletRequest request, Model model) {
        int page = 0;
        int size = 4;
        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }
        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }
        model.addAttribute("listCategory",categoryRepsitory.findAll());
        model.addAttribute("listProduct", productRepsitory.findByProductProductTypeOld(PageRequest.of(page, size)));
        return "client/productOld";
    }

}
