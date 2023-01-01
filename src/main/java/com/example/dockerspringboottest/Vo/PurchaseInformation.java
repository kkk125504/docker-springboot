package com.example.dockerspringboottest.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseInformation {
    private int id;
    private String itemName;
    private int price;
    private String buyerName;
    private String purchaseDate;
    private int purchaseId;
}