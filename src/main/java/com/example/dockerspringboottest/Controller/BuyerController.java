package com.example.dockerspringboottest.Controller;

import com.example.dockerspringboottest.Service.BuyerService;
import com.example.dockerspringboottest.Vo.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuyerController {
    @Autowired
    public BuyerService buyerService;
    @GetMapping("/getBuyerList")
    public List<Buyer> getBuyerList(){

        return buyerService.getBuyerList();
    }
}
