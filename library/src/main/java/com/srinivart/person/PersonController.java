package com.srinivart.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping
    List<Person> GetPersons(){
        return personRepository.findAll();
    }

    @PostMapping
    Person createPerson(@RequestBody Person person){
        return personRepository.save(person);
    }

    @PostMapping("/saveAll")
    List<Person> createPersons(@RequestBody List<Person> person){
        return personRepository.saveAll(person);
    }




}
