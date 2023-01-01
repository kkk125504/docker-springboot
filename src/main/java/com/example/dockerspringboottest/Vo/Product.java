package com.example.dockerspringboottest.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String itemName;
    private int price;
    private String register_date;
    private String companyName;
}