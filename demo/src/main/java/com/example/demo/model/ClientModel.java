package com.example.demo.model;

import com.example.demo.model.entities.Product;
import com.example.demo.repository.ProductRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ClientModel {
    @Autowired
    ProductRepsitory repo;
//    public Page<Product> listAll(int pageNumber,String sortField, String sortDir,
//                                 String keywrod){
//
//        Sort sort = Sort.by(sortField);
//        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
//
//        Pageable pageable = PageRequest.of(pageNumber -1, 4,sort);
//        if (keywrod !=null){
//            return repo.findAll(keywrod,pageable);
//        }
//        return  repo.findAll(pageable);
//    }



}
