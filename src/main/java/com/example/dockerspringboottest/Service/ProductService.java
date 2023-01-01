package com.example.dockerspringboottest.Service;

import com.example.dockerspringboottest.Repository.ProductRepository;
import com.example.dockerspringboottest.Vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public List<Product> getProductList() {

        return productRepository.getProductList();
    }
}
