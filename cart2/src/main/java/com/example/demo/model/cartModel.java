package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;


public class cartModel {

    private List<String> products=new ArrayList<String>();
    private double TotalPrice;
    private String CouponCode;
    private double discountedPrice;
    private String Message;

    public List<String> getProducts() {
        return products;
    }
    public void setProducts(List<String> products) { this.products = products; }

    public double getTotalPrice() {
        return TotalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        TotalPrice = totalPrice;
    }

    public String getCouponCode() {
        return CouponCode;
    }
    public void setCouponCode(String couponCode) { CouponCode = couponCode; }

    public double getDiscountedPrice() {
        return discountedPrice;
    }
    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getMessage() { return Message; }
    public void setMessage(String message) { this.Message = message; }
}
