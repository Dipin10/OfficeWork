package com.dipinprojectmatra.pojo.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResponseDto {
    private long id;
    private String title;
    private String description;
    private Date publishedDate;
    private List<AuthorResponseDto> authors;

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

    public List<AuthorResponseDto> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorResponseDto> authors) {
        this.authors = authors;
    }
}
