package com.example.dockerspringboottest.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buyer {
    private int id;
    private String buyerName;
    private String phoneNumber;
}