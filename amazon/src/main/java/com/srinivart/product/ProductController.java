package com.srinivart.product;

import com.srinivart.customer.Customer;
import com.srinivart.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    List<Product> getProducts(){
        return productRepository.findAll();
    }

    @PostMapping
    Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
       }


     @PutMapping("/{pname}/customer/{name}")
     Product purchaseProduct(@PathVariable String pname, @PathVariable String name){

         Product product = productRepository.findById(pname).get();
         Customer customer = customerRepository.findById(name).get();

         product.setCustomer(customer);
         return productRepository.save(product);

     }

     @PostMapping("/saveAll")
    List<Product> createProducts(@RequestBody List<Product> product){
        return productRepository.saveAll(product);
     }

}
