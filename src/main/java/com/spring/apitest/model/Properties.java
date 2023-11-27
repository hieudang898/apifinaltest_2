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
@Table(name = "properties")
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propertyid")
    private int propertyId;
    @Column(name = "propertyname")
    private String propertyName;
    @Column(name = "propertysort")
    private int propertySort;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "productid", referencedColumnName = "productid")
    private Products products;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "properties", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<PropertyDetails> propertyDetails;
}
