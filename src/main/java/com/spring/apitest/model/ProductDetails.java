package com.spring.apitest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "productdetails")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productdetailid")
    private int productdetailid;
    @Column(name = "productdetailname")
    private String productDetailName;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private float price;
    @Column(name = "shellprice")
    private float shellPrice;
    @Column(name = "parentid",insertable = false,updatable = false)
    private Integer parentId;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productDetails", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<ProductDetailPropertyDetails> productDetailPropertyDetailsList;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "parentid")
    private ProductDetails productDetails;

}
