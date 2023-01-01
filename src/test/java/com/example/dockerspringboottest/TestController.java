package com.example.dockerspringboottest;

import com.example.dockerspringboottest.Service.ProductService;
import com.example.dockerspringboottest.Vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    public ProductService productService;
    @GetMapping("/")
    public List<Product> getProduct(){
        return productService.getProductList();
    }
    @GetMapping("hello")
    public String hellow(){

        return "hi hellow";
    }
}
