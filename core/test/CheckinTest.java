package com.latecheckin;

import static org.junit.Assert.*;

import org.junit.Test;

import twitter4j.Place;
import twitter4j.ResponseList;
import twitter4j.TwitterException;

public class CheckinTest {
    @Test
    public void getLocations() {
        try {
            CurrentLocation current = new CurrentLocation(35.690921,139.700258);
            ResponseList<Place> places = new Checkin().getPlaces(current);
            for(Place place : places){
                System.out.println(place);
            }
            assertNotNull(places);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}