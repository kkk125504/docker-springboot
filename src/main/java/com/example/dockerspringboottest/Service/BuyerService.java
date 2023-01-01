package com.example.dockerspringboottest.Service;

import com.example.dockerspringboottest.Repository.BuyerRepository;
import com.example.dockerspringboottest.Vo.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;


    public List<Buyer> getBuyerList() {
      return buyerRepository.getBuyerList();
    }
}
