package com.sparta.thespringsons.finalapiproject.model.entities;

import com.sparta.thespringsons.finalapiproject.model.fields.Awards;
import com.sparta.thespringsons.finalapiproject.model.fields.Imdb;
import com.sparta.thespringsons.finalapiproject.model.fields.Tomato;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Arrays;

@Document("embedded_movies")
public class EmbeddedMovie {
    @Id
    private String id;

    private Awards awards;
    private String[] cast;

    private String[] countries;

    private String[] directors;

    private String fullplot;

    private String[] genres;

    private Imdb imdb;

    private String[] languages;

    private String lastupdated;

    private Integer num_mflix_comments;

    private String plot;

    private double[] plot_embedding;

    private String rating;

//    @Field("released")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    private Date released;
    private String released;

    private Integer runtime;

    private String title;

    @Field(name = "tomatoes")
    private Tomato tomatoes;

    private String type;

    private String[] writers;

    private String year;

    private String poster;

    public String getId() {
        return id;
    }

    public Awards getAwards() {
        return awards;
    }

    public String[] getCast() {
        return cast;
    }

    public String[] getCountries() {
        return countries;
    }

    public String[] getDirectors() {
        return directors;
    }

    public String getFullplot() {
        return fullplot;
    }

    public String[] getGenres() {
        return genres;
    }

    public Imdb getImdb() {
        return imdb;
    }

    public String[] getLanguages() {
        return languages;
    }

    public String getLastupdated() {
        return lastupdated;
    }

    public Integer getNum_mflix_comments() {
        return num_mflix_comments;
    }

    public String getPlot() {
        return plot;
    }

    public double[] getPlot_embedding() {
        return plot_embedding;
    }

    public String getRating() {
        return rating;
    }

    public String getReleased() {
        return released;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public String getTitle() {
        return title;
    }

    public Tomato getTomato() {
        return tomatoes;
    }

    public String getType() {
        return type;
    }

    public String[] getWriters() {
        return writers;
    }

    public String getYear() {
        return year;
    }

    public String getPoster() {
        return poster;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAwards(Awards awards) {
        this.awards = awards;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }

    public void setDirectors(String[] directors) {
        this.directors = directors;
    }

    public void setFullplot(String fullplot) {
        this.fullplot = fullplot;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public void setImdb(Imdb imdb) {
        this.imdb = imdb;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public void setLastupdated(String lastupdated) {
        this.lastupdated = lastupdated;
    }

    public void setNum_mflix_comments(Integer num_mflix_comments) {
        this.num_mflix_comments = num_mflix_comments;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public void setPlot_embedding(double[] plot_embedding) {
        this.plot_embedding = plot_embedding;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTomatoes(Tomato tomatoes) {
        this.tomatoes = tomatoes;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWriters(String[] writers) {
        this.writers = writers;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

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
                ", tomatoes=" + tomatoes +
                ", type='" + type + '\'' +
                ", writers=" + Arrays.toString(writers) +
                ", year=" + year +
                ", poster='" + poster + '\'' +
                '}';
    }
}
