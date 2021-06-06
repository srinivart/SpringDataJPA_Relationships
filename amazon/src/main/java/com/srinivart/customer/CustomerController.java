package com.srinivart.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostLoad;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    List<Customer> getCusomters(){
        return customerRepository.findAll();
    }

    @PostMapping
    Customer createCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @PostMapping("/saveAll")
    List<Customer> createCustomers(@RequestBody List<Customer> customer){
        return customerRepository.saveAll(customer);
    }


}
