package org.sid.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;



    //@OneToMany(mappedBy = "category")
    //@JsonIgnore
    //@JsonManagedReference

//    @JsonIgnoreProperties("category")
//    private List<Product> productsList=new ArrayList<>();

//    @JsonManagedReference
//    @OneToMany(mappedBy="category",targetEntity=Product.class,cascade=CascadeType.ALL,
//            fetch=FetchType.EAGER)
    @OneToMany(mappedBy = "category")
    //@JsonIgnore
    private List<Product> productList;
    public Category() {
    }

    public Category(String name, List<Product> productList) {
        this.name = name;
        this.productList = productList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
