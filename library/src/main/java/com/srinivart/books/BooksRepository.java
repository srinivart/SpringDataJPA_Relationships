package com.srinivart.books;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface BooksRepository extends JpaRepository<Books,Long> {

    //Books findByName(String bname);
}
