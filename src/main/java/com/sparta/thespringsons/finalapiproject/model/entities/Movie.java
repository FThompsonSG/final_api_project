package com.sparta.thespringsons.finalapiproject.model.entities;

import com.sparta.thespringsons.finalapiproject.model.fields.Awards;
import com.sparta.thespringsons.finalapiproject.model.fields.Imdb;
import com.sparta.thespringsons.finalapiproject.model.fields.Tomato;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Document("movies")
public class Movie {

    @Id
    private String id;
    private Awards awards;
    private List<String> cast;
    private List<String> countries;
    private List<String> directors;
    private String fullplot;
    private List<String> genres;
    private Imdb imdb;
    private List<String> languages;
    private String lastupdated;
    private Integer num_mflix_comments;
    private String plot;
    private String poster;
    //could be enum
    private String rated;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date released;
    private Integer runtime;
    private String title;
    private Tomato tomatoes;
    //could be enum
    private String type;
    private Integer year;
    private List<String> writers;

    public Movie() {}

    public Movie(String id, Awards awards, List<String> cast,
                 List<String> countries, List<String> directors,
                 String fullplot, List<String> genres, Imdb imdb,
                 List<String> languages, String lastupdated,
                 Integer num_mflix_comments, String plot,
                 String poster, String rated, Date released,
                 Integer runtime, String title, Tomato tomatoes,
                 String type, Integer year, List<String> writers) {
        this.id = id;
        this.awards = awards;
        this.cast = cast;
        this.countries = countries;
        this.directors = directors;
        this.fullplot = fullplot;
        this.genres = genres;
        this.imdb = imdb;
        this.languages = languages;
        this.lastupdated = lastupdated;
        this.num_mflix_comments = num_mflix_comments;
        this.plot = plot;
        this.poster = poster;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.title = title;
        this.tomatoes = tomatoes;
        this.type = type;
        this.year = year;
        this.writers = writers;
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

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public String getFullplot() {
        return fullplot;
    }

    public void setFullplot(String fullplot) {
        this.fullplot = fullplot;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Imdb getImdb() {
        return imdb;
    }

    public void setImdb(Imdb imdb) {
        this.imdb = imdb;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
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

    public Tomato getTomatoes() {
        return tomatoes;
    }

    public void setTomatoes(Tomato tomatoes) {
        this.tomatoes = tomatoes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }
}
