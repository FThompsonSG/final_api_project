package com.sparta.thespringsons.finalapiproject.model.fields;

public class Geo {

    private float[] coordinates;
    private String type;

    public Geo(float[] coordinates, String type) {
        this.coordinates = coordinates;
        this.type = type;
    }

    public float[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(float[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
