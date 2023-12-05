package com.sparta.thespringsons.finalapiproject.model.fields;

public class Address {

    private String city;
    private String state;
    private String street1;
    private String zipcode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Address(String city, String state, String street1, String zipcode) {
        this.city = city;
        this.state = state;
        this.street1 = street1;
        this.zipcode = zipcode;
    }
}
