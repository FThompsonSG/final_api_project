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

    public String year;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Awards getAwards() {
        return awards;
    }

    public void setAwards(Awards awards) {
        this.awards = awards;
    }

    public String[] getCast() {
        return cast;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public String[] getCountries() {
        return countries;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }

    public String[] getDirectors() {
        return directors;
    }

    public void setDirectors(String[] directors) {
        this.directors = directors;
    }

    public String getFullplot() {
        return fullplot;
    }

    public void setFullplot(String fullplot) {
        this.fullplot = fullplot;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public Imdb getImdb() {
        return imdb;
    }

    public void setImdb(Imdb imdb) {
        this.imdb = imdb;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(String lastupdated) {
        this.lastupdated = lastupdated;
    }

    public Integer getNum_mflix_comments() {
        return num_mflix_comments;
    }

    public void setNum_mflix_comments(Integer num_mflix_comments) {
        this.num_mflix_comments = num_mflix_comments;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String[] getPlot_embedding() {
        return plot_embedding;
    }

    public void setPlot_embedding(String[] plot_embedding) {
        this.plot_embedding = plot_embedding;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Tomato getTomato() {
        return tomato;
    }

    public void setTomato(Tomato tomato) {
        this.tomato = tomato;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getWriters() {
        return writers;
    }

    public void setWriters(String[] writers) {
        this.writers = writers;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
