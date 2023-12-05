package com.sparta.thespringsons.finalapiproject.model.fields;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Tomato {

    private Reviewer critic;

    @Field("dvd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date dvd;

    private Integer fresh;

    @Field("lastUpdated")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date lastUpdated;

    private String production;

    private Integer rotten;

    private Reviewer viewer;

    private Double rating;

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Reviewer getCritic() {
        return critic;
    }

    public void setCritic(Reviewer critic) {
        this.critic = critic;
    }

    public Date getDvd() {
        return dvd;
    }

    public void setDvd(Date dvd) {
        this.dvd = dvd;
    }

    public Integer getFresh() {
        return fresh;
    }

    public void setFresh(Integer fresh) {
        this.fresh = fresh;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public Integer getRotten() {
        return rotten;
    }

    public void setRotten(Integer rotten) {
        this.rotten = rotten;
    }

    public Reviewer getViewer() {
        return viewer;
    }

    public void setViewer(Reviewer viewer) {
        this.viewer = viewer;
    }
}

