package com.sparta.thespringsons.finalapiproject.model.fields;

public class Reviewer {

    private Integer meter;

    private Integer numReviews;

    private Double rating;

    public Integer getMeter() {
        return meter;
    }

    public void setMeter(Integer meter) {
        this.meter = meter;
    }

    public Integer getNumReviews() {
        return numReviews;
    }

    public void setNumReviews(Integer numReviews) {
        this.numReviews = numReviews;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Reviewer{" +
                "meter=" + meter +
                ", numReviews=" + numReviews +
                ", rating=" + rating +
                '}';
    }
}
