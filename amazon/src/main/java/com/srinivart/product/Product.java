package com.srinivart.product;

import com.srinivart.customer.Customer;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    private String pname;
    private int price;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cust_name", referencedColumnName = "name")
    private Customer customer;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
