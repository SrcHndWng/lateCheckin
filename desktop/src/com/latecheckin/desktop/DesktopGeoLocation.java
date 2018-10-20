package com.latecheckin.desktop;

import com.latecheckin.DeviceLocation;

public class DesktopGeoLocation implements DeviceLocation {
    public DesktopGeoLocation(){
    }

    @Override
    public Coordinate getCurrentCoordinate(){
        // TODO: Get correct latitude, longitude.
        return DeviceLocation.Coordinate.create(35.690921,139.700258);
    }
}
