package com.spring.apitest.repository;

import com.spring.apitest.model.PropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDetailsRepo extends JpaRepository<PropertyDetails, Integer> {
}
