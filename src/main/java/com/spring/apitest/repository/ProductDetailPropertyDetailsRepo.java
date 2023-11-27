package com.spring.apitest.repository;

import com.spring.apitest.model.ProductDetailPropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailPropertyDetailsRepo extends JpaRepository<ProductDetailPropertyDetails,Integer> {
}
