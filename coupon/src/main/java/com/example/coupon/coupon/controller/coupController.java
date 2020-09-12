package com.example.coupon.coupon.controller;

import com.example.coupon.coupon.model.coupModel;
import com.example.coupon.coupon.repository.coupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class coupController {

    @Autowired
    coupRepo repository;

    @GetMapping(value="/coupon")
    public List<coupModel> getCoupons(){

        return repository.findAll();
    }
    @GetMapping(value="/coupon/{id}")
    public coupModel getCoupon(@PathVariable("id") String id){

        return repository.findById(id).get();
    }
    @PostMapping(value="/coupon")
    public coupModel createCoupon(@RequestBody coupModel coupon){

        return repository.save(coupon);
    }
}
