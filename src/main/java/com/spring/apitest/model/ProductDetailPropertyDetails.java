package com.spring.apitest.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "productdetailpropertydetails")
public class ProductDetailPropertyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productdetailpropertydetailid")
    private int productDetailPropertyDetailId;

// Trong ProductDetailPropertyDetails
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "productdetailid", referencedColumnName = "productdetailid")  // Sử dụng @JoinColumn thay vì @Column
    private ProductDetails productDetails;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "productid", referencedColumnName = "productid")  // Sử dụng @JoinColumn thay vì @Column
    private Products products;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "propertydetailid", referencedColumnName = "propertydetailid")  // Sử dụng @JoinColumn thay vì @Column
    private PropertyDetails propertyDetails;

}
