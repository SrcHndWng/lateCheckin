package com.latecheckin;

public class Location {
    private String streetAddress;
    private String country;
    private String fullName;

    private Location(String streetAddress, String country, String fullName){
        this.streetAddress = streetAddress;
        this.country = country;
        this.fullName = fullName;
    }

    public static Location create(twitter4j.Place place){
        return new Location(place.getStreetAddress(), place.getCountryCode(), place.getFullName());
    }

    public String getStreetAddress(){
        return streetAddress;
    }

    public String getCountry(){
        return country;
    }

    public String getFullName(){
        return fullName;
    }
}
