package com.example.demo.model;

import java.util.ArrayList;

public class cartDyn {

    //private String[] prodInput;
    ArrayList<String> prodInput = new ArrayList<String>();
    private String coupInput;
    public ArrayList<String> getProdInput() { return prodInput; }
    public void setProdInput(ArrayList<String> prodInput) {this.prodInput = prodInput; }


    //List<String> coupInput = new ArrayList<String>();

    /*public String[] getProdInput() {
        return prodInput;
    }
    public void setProdInput(String[] prodInput) { this.prodInput = prodInput; }*/

    public String getCoupInput() {
        return coupInput;
    }
    public void setCoupInput(String coupInput) {
        this.coupInput = coupInput;
    }
}


