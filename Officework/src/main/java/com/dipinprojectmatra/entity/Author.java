package com.dipinprojectmatra.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="title")
    private String title;

    @ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="Authors")
    private Set<Book> Book=new HashSet<>();
    public Author(){

    }
    public Author(String title) {
        this.title = title;
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

    public Set<Book> getPosts() {
        return Book;
    }

    public void setPosts(Set<Book> Book) {
        this.Book = Book;
    }










}
