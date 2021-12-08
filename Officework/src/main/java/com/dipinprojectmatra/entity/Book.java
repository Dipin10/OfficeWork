package com.dipinprojectmatra.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
   private long id;
@Column(name="title")
   private String title;
   @Column(name="Description")
   private String description;
   @Column(name="Content")
   private String Content;
    @Column(name="posted_at")
   private Date postedAt=new Date();



   @Column(name="last_updated")
   private Date LastUpdatedAt=new Date();

    @ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name="book_author",
            joinColumns = {@JoinColumn(name="book_id")},
    inverseJoinColumns= {@JoinColumn(name="author_id")})
    private Set<Author> Authors=new HashSet<>();

    public Book() {
    }

    public Book(String title, String description, String content) {
        this.title = title;
        this.description = description;
        Content = content;
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

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public Date getLastUpdatedAt() {
        return LastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        LastUpdatedAt = lastUpdatedAt;
    }

    public Set<Author> getAuthors() {
        return Authors;
    }

    public void setAuthors(Set<Author> authors) {
        Authors = authors;
    }
}
