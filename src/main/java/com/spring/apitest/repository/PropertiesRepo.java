package com.spring.apitest.repository;

import com.spring.apitest.model.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesRepo extends JpaRepository<Properties,Integer> {
}
