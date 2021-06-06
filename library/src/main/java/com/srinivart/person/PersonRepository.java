package com.srinivart.person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface PersonRepository extends JpaRepository<Person,Long> {

    //Person findByName(String name);
}
