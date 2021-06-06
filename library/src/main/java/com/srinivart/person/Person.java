package com.srinivart.person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.srinivart.books.Books;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;
    private String location;

    @JsonIgnore
    @ManyToMany(mappedBy = "readByPersons")
    private Set<Books> books = new HashSet<>();



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public Set<Books> getBooks() {
        return books;
    }



}
