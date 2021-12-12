package com.dipinprojectmatra.controller;

import com.dipinprojectmatra.AuthorNotFoundException;
import com.dipinprojectmatra.entity.Author;
import com.dipinprojectmatra.pojo.response.AuthorResponseDto;
import com.dipinprojectmatra.pojo.response.BookResponseDto;
import com.dipinprojectmatra.service.AuthorService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class AuthorController {
    private final AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;


    }


    @GetMapping("/authors")
    public List<AuthorResponseDto> getAllAuthor(@Param("noOfBooks") Integer noOfBooks) {
        return authorService.getAllAuthor(noOfBooks);

    }

    @GetMapping("/authors/{authorId}")
    public AuthorResponseDto getAuthor(@PathVariable("authorId") long authorId) throws AuthorNotFoundException {
        return authorService.getAuthor(authorId);

    }

    @GetMapping("/authors/{authorId}/books")
    public List<BookResponseDto> getBooks(@PathVariable("authorId") long authorId) throws AuthorNotFoundException {
        return authorService.getBooksByAuthor(authorId);

    }


    @PostMapping("/authors")
    Author addAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }
}

