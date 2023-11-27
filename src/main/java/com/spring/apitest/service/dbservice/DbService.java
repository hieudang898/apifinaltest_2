package com.spring.apitest.service.dbservice;

import com.spring.apitest.service.cservice.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {
    @Autowired
    public ProductDetailsService productDetailsService;
}
