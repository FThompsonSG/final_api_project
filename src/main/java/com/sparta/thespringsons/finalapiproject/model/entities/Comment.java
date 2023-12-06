package com.sparta.thespringsons.finalapiproject.model.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("comments")
public class Comment {
    @Id
    private String id;

    private Date date;
    private String email;
    private String movieId;
    private String name;
    private String text;

    public Comment(String id, Date date, String email, String movieId, String name, String text) {
        this.id = id;
        this.date = date;
        this.email = email;
        this.movieId = movieId;
        this.name = name;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
