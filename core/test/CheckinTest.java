package com.latecheckin;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

import twitter4j.TwitterException;

public class CheckinTest {
    @Test
    public void getLocations() {
        try {
            Coordinate current = Coordinate.create(35.690921,139.700258);
            List<Location> locations = new Checkin().getPlaces(current);
            for(Location location : locations){
                System.out.printf("country = %s, fullName = %s%n", location.getCountry(), location.getFullName());
            }
            assertNotNull(locations);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}