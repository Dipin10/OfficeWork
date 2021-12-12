package com.dipinprojectmatra.pojo.request;

import java.util.Date;
import java.util.List;

public class BookRequestDto {
    private long id;
    private String title;
    private String description;
    private Date publishedDate;
    private List<AuthorRequestDto> authors;

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

    public List<AuthorRequestDto> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorRequestDto> authors) {
        this.authors = authors;
    }
}
