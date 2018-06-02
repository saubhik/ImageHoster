package com.upgrad.ImageHoster.model;

import javax.persistence.*;

@Entity
@Table
public class Comment {

    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String body;

    @Column
    private String author;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Image image;

    public Comment(String body, String author, Image image) {
        this.body = body;
        this.author = author;
        this.image = image;
    }

    public Comment() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
