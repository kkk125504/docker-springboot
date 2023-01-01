package com.example.dockerspringboottest.Service;

import com.example.dockerspringboottest.Repository.CompanyRepository;
import com.example.dockerspringboottest.Repository.ProductRepository;
import com.example.dockerspringboottest.Vo.Company;
import com.example.dockerspringboottest.Vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;


    public List<Company> getCompanyList() {
      return companyRepository.getCompanyList();
    }
}
