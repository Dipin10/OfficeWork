package com.dipinprojectmatra.controller;
import java.util.List;

import com.dipinprojectmatra.BookNotFoundException;
import com.dipinprojectmatra.entity.Book;
import com.dipinprojectmatra.repository.BookRepository;
import org.springframework.web.bind.annotation.*;


@RestController
public class BookController {
    private final BookRepository repository;

    BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/book")
    public List<Book> all() {                                              //make public
        return repository.findAll();
    }

    @PostMapping("/book")
    Book newBook(@RequestBody Book newBook) {
        return repository.save(newBook);
    }


    Book one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }
     @GetMapping("/author/id")
    @PutMapping("/book/{id}")
    Book replaceBook(@RequestBody Book newBook, @PathVariable Long id) {
        return repository.findById(id).map(Book -> {
            Book.setAuthors(newBook.getAuthors());
            Book.setId(newBook.getId());
            Book.setTitle(newBook.getTitle());
            Book.setContent(newBook.getContent());
            Book.setPostedAt(newBook.getPostedAt())
            ;
            Book.setLastUpdatedAt(newBook.getLastUpdatedAt());
            return repository.save(Book);


        }).orElseGet(() -> {
            newBook.setId(id);
            return repository.save(newBook);
        });
    }

    @DeleteMapping("/book/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }
}





