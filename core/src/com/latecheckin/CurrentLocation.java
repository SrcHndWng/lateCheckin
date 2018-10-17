package com.latecheckin;

public class CurrentLocation {
    private double latitude;
    private double longitude;

    public CurrentLocation(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public double getLatitude(){
        return latitude;
    }
    public double getLongtitude(){
        return longitude;
    }
}
