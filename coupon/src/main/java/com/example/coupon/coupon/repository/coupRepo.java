package com.example.coupon.coupon.repository;

import com.example.coupon.coupon.model.coupModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface coupRepo extends JpaRepository<coupModel,String> {
}
