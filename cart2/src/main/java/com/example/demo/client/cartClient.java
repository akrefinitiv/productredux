package com.example.demo.client;

import com.example.demo.model.cartDyn;
import com.example.demo.model.cartModel;
import com.example.demo.model.couponModel;
import com.example.demo.model.productModel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

@Component
@RestController
public class cartClient implements CommandLineRunner {

    private String prodLoc;
    private String coupLoc;
    private int temp = 0;

    @Value("${external.product.url}")
    private String productURL;

    @Value("${external.coupon.url}")
    private String couponURL;

    // list of product and coupons to cross check with user input
    ArrayList<String> prods = new ArrayList<String>(Arrays.asList("NTB", "INK", "PNC", "PEN"));
    //String[] prods = {"NTB", "INK", "PNC", "PEN"};
    ArrayList<String> coups = new ArrayList<String>(Arrays.asList("15OFF", "25OFF", "50OFF"));
    //String[] coups = {"15OFF", "25OFF", "50OFF"};
    ArrayList<String> pList = new ArrayList<String>();

    @GetMapping(value="/cart")
    public cartModel callproduct(@RequestBody cartDyn cartdyn){

        double sum = 0L;
        cartModel cart = new cartModel();
        RestTemplate restTemplate = new RestTemplate();
        pList.clear();

        //null initialization
        cart.setProducts(pList);
        cart.setTotalPrice(0L);
        cart.setDiscountedPrice(0L);
        cart.setCouponCode("");

        //dynamic input from user
        String[] a = cartdyn.getProdInput().toArray(new String[0]);
        //String[] a = cartdyn.getProdInput();
        String b = cartdyn.getCoupInput();

        //check corner cases
        if(prods.containsAll(Arrays.asList(a)) /*&& coups.contains(b)*/) {

            for (String i : a) {
                i = i.toUpperCase();
                prodLoc = productURL.concat(i);
                productModel product = restTemplate.getForObject(prodLoc, productModel.class);
                sum += product.getPrice();
                pList.add(i);
            }

            // corner case for no coupon input
            if (b == null) {
                cart.setProducts(pList);
                cart.setTotalPrice(sum);
                cart.setDiscountedPrice(sum);
                cart.setCouponCode("No Discount");
                cart.setMessage("No Message");
                return cart;
            }

            //coupon code extraction
            coupLoc = couponURL.concat(b);
            couponModel coupon = restTemplate.getForObject(coupLoc, couponModel.class);
            String discountString = coupon.getCouponCode();
            String discountInt = discountString.replaceAll("[^0-9]", "");
            double discount = Integer.parseInt(discountInt);
            double discountPrice = (100 - discount) * (sum) / 100d;

            //output
            cart.setProducts(pList);
            cart.setTotalPrice(sum);
            cart.setDiscountedPrice(discountPrice);
            cart.setCouponCode(discountString);

            return cart;

        }
        else {
            cart.setMessage("Invalid product or coupon");
            return cart;
        }
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
