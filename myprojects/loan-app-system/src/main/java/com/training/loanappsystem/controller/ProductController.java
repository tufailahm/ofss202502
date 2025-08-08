package com.training.loanappsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @RequestMapping("")
    public String index() {
        return "index";
    }
    @RequestMapping("/hello")
    public String hello() {
        return "neha";
    }
    @RequestMapping("/viewAllProducts")
    public String viewAllProducts() {
        return "viewAllProducts";
    }
    @RequestMapping("/addProduct")
    public String addProduct() {
        return "addProduct";
    }
}

