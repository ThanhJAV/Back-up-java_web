package com.codegym.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Blog")
@NamedQuery(name = "findAllBlog", query = "select b from Blog b")
@NamedQuery(name = "findBlogById", query = "select b from Blog b where b.id = :id")
//@NamedQuery(name = "findBlogByName" , query = "select b from Blog b where b.author = :author")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String category;
    private Date dateCreated;
    private String storyName;
    private String storyContent;

    public Blog() {
    }

    public Blog(String author, String category, Date dateCreated, String storyName, String storyContent) {
        this.author = author;
        this.category = category;
        this.dateCreated = dateCreated;
        this.storyName = storyName;
        this.storyContent = storyContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }

    public String getStoryContent() {
        return storyContent;
    }

    public void setStoryContent(String storyContent) {
        this.storyContent = storyContent;
    }
}
