package com.srinivart.books;

import com.srinivart.person.Person;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String bname;
    private String author;


    @ManyToMany
    @JoinTable(name ="read_by",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "books_id")
      )
    Set<Person> readByPersons = new HashSet<>();



    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }




    public Set<Person> getReadByPersons() {
        return readByPersons;
    }

}
