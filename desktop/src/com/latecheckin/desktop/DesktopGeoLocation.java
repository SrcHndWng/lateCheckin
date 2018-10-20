package com.latecheckin.desktop;

import com.latecheckin.Coordinate;
import com.latecheckin.GeoLocation;

public class DesktopGeoLocation implements GeoLocation {
    public DesktopGeoLocation(){
    }

    @Override
    public Coordinate getCurrentLocation(){
        // TODO: Get correct latitude, longitude.
        return Coordinate.create(35.690921,139.700258);
    }
}
