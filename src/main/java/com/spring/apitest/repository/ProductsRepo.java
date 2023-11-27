package com.spring.apitest.repository;

import com.spring.apitest.model.ProductDetails;
import com.spring.apitest.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepo extends JpaRepository<Products,Integer> {

}
