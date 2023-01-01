package com.example.dockerspringboottest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String itemName;
    private int price;
    private String register_date;
    private String company;
}
