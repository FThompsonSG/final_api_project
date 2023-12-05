package com.sparta.thespringsons.finalapiproject.model.entities;

import com.sparta.thespringsons.finalapiproject.model.fields.Awards;
import com.sparta.thespringsons.finalapiproject.model.fields.Imdb;
import com.sparta.thespringsons.finalapiproject.model.fields.Tomato;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Arrays;
import java.util.Date;

@Document("embedded_movies")
public class EmbeddedMovie {
    @Id
    public String id;

    public Awards awards;
    public String[] cast;

    public String[] countries;

    public String[] directors;

    public String fullplot;

    public String[] genres;

    public Imdb imdb;

    public String[] languages;

    public String lastupdated;

    public Integer num_mflix_comments;

    public String plot;

    public String[] plot_embedding;

    public String rating;

    @Field("released")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date released;

    public Integer runtime;

    public String title;

    public Tomato tomato;

    public String type;

    public String[] writers;

    public Integer year;

    public String poster;

    @Override
    public String toString() {
        return "EmbeddedMovies{" +
                "id='" + id + '\'' +
                ", awards=" + awards +
                ", cast=" + Arrays.toString(cast) +
                ", countries=" + Arrays.toString(countries) +
                ", directors=" + Arrays.toString(directors) +
                ", fullplot='" + fullplot + '\'' +
                ", genres=" + Arrays.toString(genres) +
                ", imdb=" + imdb +
                ", languages=" + Arrays.toString(languages) +
                ", lastupdated='" + lastupdated + '\'' +
                ", num_mflix_comments=" + num_mflix_comments +
                ", plot='" + plot + '\'' +
                ", plot_embedding=" + Arrays.toString(plot_embedding) +
                ", rating='" + rating + '\'' +
                ", released=" + released +
                ", runtime=" + runtime +
                ", title='" + title + '\'' +
                ", tomatoes=" + tomato +
                ", type='" + type + '\'' +
                ", writers=" + Arrays.toString(writers) +
                ", year=" + year +
                ", poster='" + poster + '\'' +
                '}';
    }
}
