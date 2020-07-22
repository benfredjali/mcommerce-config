package org.sid.entities;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Product implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String price;

    //@ManyToOne
    //@JsonIgnore
    //@JsonBackReference

//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    @JsonIgnoreProperties("productsList")
   //@JsonBackReference
    //@JsonIgnore

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appUser_id")
    @JsonIgnore
     private AppUser appUser;

//     @ManyToMany
//     private List<Etudiant> etudiantList=new ArrayList<>();

    public Product() {
    }

    public Product(String name, String price, Category category, AppUser appUser) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.appUser = appUser;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
