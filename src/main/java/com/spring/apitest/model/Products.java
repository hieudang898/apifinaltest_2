package com.spring.apitest.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Properties;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private int productId;
    @Column(name = "productname")
    private String productName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "products", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ProductDetailPropertyDetails> productDetailPropertyDetailsList;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "products", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<Properties> properties;

}
