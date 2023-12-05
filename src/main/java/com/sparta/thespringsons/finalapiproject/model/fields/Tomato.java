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

    public String production;

    public Integer rotten;

    public Reviewer viewer;

}

