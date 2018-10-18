package com.latecheckin;

public class Location {
    private double latitude;
    private double longitude;

    private Location(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static Location createLocate(double latitude, double longitude){
        return new Location(latitude, longitude);
    }

    public double getLatitude(){
        return latitude;
    }
    public double getLongitude(){
        return longitude;
    }
}
