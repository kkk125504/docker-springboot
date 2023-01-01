package com.example.dockerspringboottest.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private int id;
    private String companyName;
    private String ceoName;
    private String phoneNumber;
}