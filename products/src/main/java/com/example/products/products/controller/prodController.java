package com.example.products.products.controller;

import com.example.products.products.model.prodModel;
import com.example.products.products.repository.prodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class prodController {
    @Autowired
    prodRepo repository;

    @GetMapping(value = "/products")
    public List<prodModel> getProducts(){

        return repository.findAll();
    }
    @GetMapping(value = "/products/{id}")
    public prodModel getProduct(@PathVariable("id") String id){

        return repository.findById(id).get();
    }
    @PostMapping(value = "/products")
    public prodModel createProduct(@RequestBody prodModel product){

        return repository.save(product);
    }
}
