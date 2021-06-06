package com.srinivart.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.srinivart.product.Product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer {

    @Id
    private String name;
    private String email;


    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Product> products;




    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<Product> getProducts() {
        return products;
    }
}
