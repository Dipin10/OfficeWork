package com.dipinprojectmatra.controller;
import java.util.List;

import com.dipinprojectmatra.AuthorNotFoundException;

import com.dipinprojectmatra.entity.Author;
import com.dipinprojectmatra.entity.Book;
import com.dipinprojectmatra.repository.AuthorRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.border.TitledBorder;


@RestController

public class AuthorController {
    private final AuthorRepository repository1;


    public AuthorController(AuthorRepository repository1) {
        this.repository1 = repository1;

    }


    @GetMapping("/author")
    public List<Author> all() {
        return repository1.findAll();

    }



    @PostMapping("/author")
    Author newAuthor(@RequestBody Author newAuthor) {
        return repository1.save(newAuthor);


    }
    @GetMapping("/author/{id}")
    Author one(@PathVariable Long id) {

        return repository1.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
    }


    @PutMapping("/author/{id}")
    Author replaceAuthor(@RequestBody Author newAuthor, @PathVariable Long id) {

        return repository1.findById(id)
                .map(author -> {
                 author.setId(newAuthor.getId());
                    author.setTitle(newAuthor.getTitle());
                    return repository1.save(author);
                })
                .orElseGet(() -> {
                    newAuthor.setId(id);
                    return repository1.save(newAuthor);
                });
    }

//    @GetMapping("/author/{id}/book")
//    Book two(@PathVariable Long id){
//        return repository.findAll();
//    }

    @DeleteMapping("/author/{id}")
    void deleteAuthor(@PathVariable Long id) {
        repository1.deleteById(id);
    }

}

