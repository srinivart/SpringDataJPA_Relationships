package com.srinivart.books;

import com.srinivart.person.Person;
import com.srinivart.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    PersonRepository personRepository;

    @GetMapping
    List<Books> getBooks(){
        return booksRepository.findAll();
    }

    @PostMapping
    Books createBook(@RequestBody Books book){
        System.out.println("-->"+book.getBname());
        return booksRepository.save(book);
    }

    @PostMapping("/saveAll")
    List<Books> createBooks(@RequestBody List<Books> book){
        return booksRepository.saveAll(book);
    }

    //@PutMapping("/{bName}/assign/{pName}")
    @PutMapping("/assign/{bname}/{name}")
    Books assignPersonToBook(@PathVariable Long bname, @PathVariable Long name){

        //Books book = booksRepository.findByName(bname).get();
        //Person person = personRepository.findByName(name).get();

        Books book = booksRepository.findById(bname).get();
        Person person = personRepository.findById(name).get();

        System.out.println("-req bname->"+ bname);
        System.out.println("-req pname->"+ name);


        System.out.println("-b name->"+ book.getBname());
        System.out.println("-p name->"+ person.getName());

          book.readByPersons.add(person);
          return booksRepository.save(book);
    }



}
