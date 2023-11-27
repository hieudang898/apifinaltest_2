package com.spring.apitest.repository.dbcontext;

import com.spring.apitest.repository.*;
import com.spring.apitest.service.cservice.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbContext {
    @Autowired
    public ProductsRepo productsRepo;
    @Autowired
    public PropertiesRepo propertiesRepo;
    @Autowired
    public ProductDetailsRepo productDetailsRepo;
    @Autowired
    public PropertyDetailsRepo propertyDetailsRepo;
    @Autowired
    public ProductDetailPropertyDetailsRepo productDetailPropertyDetailsRepo;
}
