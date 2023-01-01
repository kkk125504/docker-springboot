package com.example.dockerspringboottest.Controller;

import com.example.dockerspringboottest.Service.ProductService;
import com.example.dockerspringboottest.Vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    public ProductService productService;
    @GetMapping("/getProductList")
    public List<Product> getProductList(){

        return productService.getProductList();
    }
}
