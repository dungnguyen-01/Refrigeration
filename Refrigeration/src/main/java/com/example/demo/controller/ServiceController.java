package com.example.demo.controller;

import com.example.demo.model.ServiceModel;
import com.example.demo.model.entities.Service;
import com.example.demo.repository.ServiceRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class ServiceController {
    @Autowired
    private ServiceModel serviceModel;
    @Autowired
    private ServiceRepsitory serviceRepsitory;

    @RequestMapping("/addService")
    public String addService(){
        return "admin/addService";
    }

    @PostMapping(value = "/addService")
    public String addService(@RequestParam("imageF") MultipartFile imageF,
                             @RequestParam("description") String description,
                             @RequestParam("name") String name){
        serviceModel.addService(imageF, name, description);
        return "redirect:/admin/service";
    }

    @RequestMapping("/editService/{id}")
    public String editService(@PathVariable("id")Integer id, Model model){
        Service service = serviceRepsitory.getById(id);
        model.addAttribute("service",service);
        return "admin/editService";
    }

    @PostMapping("/editedService")
    public String editService(@RequestParam("image") MultipartFile imageF,
                              @RequestParam("description") String description,
                              @RequestParam("name") String name, @RequestParam Integer id){
        serviceModel.editService(imageF,name,description, id);
        return "redirect:/admin/service";
    }

    @RequestMapping("/deleteService/{id}")
    public String deleteService(@PathVariable("id")Integer id){
        serviceRepsitory.deleteById(id);
        return "redirect:/admin/service";
    }
}
