package com.dipinprojectmatra.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "books")
public class Book {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
   private long id;
@Column(name="title")
   private String title;
   @Column(name="description")
   private String description;

   private Date publishedDate;


    @ManyToMany
    @JoinTable(name = "authors_books",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private List<Author> authors;
    public Book() {
    }

    public Book(String title, String description, Date publishedDate) {
        this.title = title;
        this.description = description;
        this.publishedDate = publishedDate;

    }

    public Book(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
