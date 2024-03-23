package com.products.backend.controller;

import com.products.backend.services.implemetantions.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServices productServices;

    @PostMapping("")
    public String save(){
        productServices.save();
        return "OK";
    }
}
