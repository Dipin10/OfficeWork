package com.dipinprojectmatra.service;

import com.dipinprojectmatra.entity.Author;
import com.dipinprojectmatra.entity.Book;
import com.dipinprojectmatra.pojo.request.BookRequestDto;
import com.dipinprojectmatra.pojo.response.AuthorResponseDto;
import com.dipinprojectmatra.pojo.response.BookResponseDto;
import com.dipinprojectmatra.repository.AuthorRepository;
import com.dipinprojectmatra.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<BookResponseDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        books.forEach(book -> {
            bookResponseDtos.add(this.getBookResponse(book));
        });
        return bookResponseDtos;
    }

    @Transactional
    public BookResponseDto saveBook(BookRequestDto book) {
        List<Author> authors = new ArrayList<>();
        book.getAuthors().forEach(authorDto -> {
            Author author = new Author();
            author.setEmail(authorDto.getEmail());
            author.setName(authorDto.getName());
            authors.add(author);
        });
        List<Author> savedAuthors = authorRepository.saveAll(authors);
        Book saveBook = new Book();
        saveBook.setTitle(book.getTitle());
        saveBook.setDescription(book.getDescription());
        saveBook.setPublishedDate(book.getPublishedDate());
        saveBook.setAuthors(savedAuthors);

        Book savedBook = bookRepository.save(saveBook);
        return this.getBookResponse(savedBook);

    }

    private BookResponseDto getBookResponse(Book book) {
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setDescription(book.getDescription());
        bookResponseDto.setTitle(book.getTitle());
        List<AuthorResponseDto> authorResponseDtos = new ArrayList<>();
        book.getAuthors().forEach(author -> {
            AuthorResponseDto authorResponseDto = new AuthorResponseDto();
            authorResponseDto.setId(author.getId());
            authorResponseDto.setName(author.getName());
            authorResponseDto.setEmail(author.getEmail());
            authorResponseDtos.add(authorResponseDto);
        });
        bookResponseDto.setAuthors(authorResponseDtos);
        return bookResponseDto;
    }

    public void deleteById(Long id) {
       bookRepository.deleteById(id);
    }
}


