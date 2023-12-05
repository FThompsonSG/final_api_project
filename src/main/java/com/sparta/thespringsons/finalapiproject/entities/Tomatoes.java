package com.sparta.thespringsons.finalapiproject.entities;

import com.sparta.thespringsons.finalapiproject.entities.Reviewer;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Tomatoes {

    public Reviewer critic;

    @Field("dvd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date dvd;

    public Integer fresh;

    @Field("lastUpdated")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date lastUpdated;

    public String production;

    public Integer rotten;

    public Reviewer viewer;

}
