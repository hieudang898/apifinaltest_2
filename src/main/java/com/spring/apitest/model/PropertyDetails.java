package com.spring.apitest.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "propertydetails")
public class PropertyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propertydetailid")
    private int propertyDetailId;
    @Column(name = "propertydetailcode")
    private String propertyDetailCode;
    @Column(name = "propertydetaildetail")
    private String propertyDetailDetail;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "propertyid", referencedColumnName = "propertyid")
    private Properties properties;
    @OneToMany(mappedBy = "propertyDetails")
    @JsonManagedReference
    private List<ProductDetailPropertyDetails> productDetailPropertyDetailsList;



}
