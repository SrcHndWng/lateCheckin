package com.latecheckin;

public interface DeviceLocation {
    public Coordinate getCurrentCoordinate();

    public class Coordinate {
        private double latitude;
        private double longitude;

        private Coordinate(double latitude, double longitude){
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public static Coordinate create(double latitude, double longitude){
            return new Coordinate(latitude, longitude);
        }

        public double getLatitude(){
            return latitude;
        }
        public double getLongitude(){
            return longitude;
        }
    }
}
