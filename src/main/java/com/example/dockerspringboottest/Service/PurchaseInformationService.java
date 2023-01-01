package com.example.dockerspringboottest.Service;

import com.example.dockerspringboottest.Repository.ProductRepository;
import com.example.dockerspringboottest.Repository.PurchaseInformationRepository;
import com.example.dockerspringboottest.Vo.Product;
import com.example.dockerspringboottest.Vo.PurchaseInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseInformationService {
    @Autowired
    private PurchaseInformationRepository purchaseInformationRepository;


    public List<PurchaseInformation> getPurchaseInformationList() {

        return purchaseInformationRepository.getPurchaseInformationList();
    }
}
