package com.dipinprojectmatra.controller;

import com.dipinprojectmatra.pojo.request.BookRequestDto;
import com.dipinprojectmatra.pojo.response.BookResponseDto;
import com.dipinprojectmatra.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;


    }


    @GetMapping("/books")
    public List<BookResponseDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/book")
    BookResponseDto addBook(@RequestBody BookRequestDto bookDto) {
        return bookService.saveBook(bookDto);


    }

    @DeleteMapping("/book/{id}")
    void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}





