package com.example.coupon.coupon.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class coupModel {
    @Id
    private String couponCode;

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }
}
