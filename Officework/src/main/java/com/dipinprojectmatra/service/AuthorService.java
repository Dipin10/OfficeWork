package com.dipinprojectmatra.service;

import com.dipinprojectmatra.AuthorNotFoundException;
import com.dipinprojectmatra.entity.Author;
import com.dipinprojectmatra.pojo.response.AuthorResponseDto;
import com.dipinprojectmatra.pojo.response.BookResponseDto;
import com.dipinprojectmatra.repository.AuthorRepository;
import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorResponseDto> getAllAuthor(Integer noOfBooks) {

        List<Author> authors = authorRepository.findAll();
        List<AuthorResponseDto> authorResponseDtos = new ArrayList<>();
        authors.forEach(author -> {
        authorResponseDtos.add(this.getAuthorResponse(author));
        });
        if (noOfBooks != null) {
            return authorResponseDtos.stream().filter(authorResponseDto -> authorResponseDto.getBooks().size() == noOfBooks).collect(Collectors.toList());
        }
        return authorResponseDtos;
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);

    }

    public List<BookResponseDto> getBooksByAuthor(long authorId) throws AuthorNotFoundException {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        author.getBooks().forEach(book -> {
            BookResponseDto bookResponseDto = new BookResponseDto();
            bookResponseDto.setId(book.getId());
            bookResponseDto.setTitle(book.getTitle());
            bookResponseDto.setDescription(book.getDescription());
            bookResponseDto.setPublishedDate(book.getPublishedDate());
            bookResponseDtos.add(bookResponseDto);

        });
        return bookResponseDtos;
    }

    public AuthorResponseDto getAuthor(long id) throws AuthorNotFoundException {
        Author author = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
        return this.getAuthorResponse(author);
    }

    private AuthorResponseDto getAuthorResponse(Author author) {
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setId(author.getId());
        authorResponseDto.setEmail(author.getEmail());
        authorResponseDto.setName(author.getName());
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        author.getBooks().forEach(book -> {
            BookResponseDto bookResponseDto = new BookResponseDto();
            bookResponseDto.setDescription(book.getDescription());
            bookResponseDto.setId(book.getId());
            bookResponseDto.setTitle(book.getTitle());
            bookResponseDtos.add(bookResponseDto);
        });
        authorResponseDto.setBooks(bookResponseDtos);
        return authorResponseDto;
    }
}

