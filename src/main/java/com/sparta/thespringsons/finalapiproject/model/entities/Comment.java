package com.sparta.thespringsons.finalapiproject.model.entities;

import jakarta.persistence.Column;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.Date;

@Document("comments")
public class Comment {
    @Id
    private String id;

    @Column(name = "is_deleted")
    private boolean deleted;
    private Date date;
    private String email;
    @Field(name = "movie_id", targetType = FieldType.OBJECT_ID)
    private String movieId;
    private String name;
    private String text;

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

    public void setId(String id) {
        this.id = id;
    }
}
