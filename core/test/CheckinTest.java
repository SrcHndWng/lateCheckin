package com.latecheckin;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

import twitter4j.TwitterException;

public class CheckinTest {
    @Test
    public void getLocations() {
        try {
            TwitterAccount twitterAccount = new TwitterAccount(
                    System.getenv("TWITTER_ACCESS_TOKEN"),
                    System.getenv("TWITTER_ACCESS_TOKEN_SECRET"),
                    System.getenv("TWITTER_CONSUMER_KEY"),
                    System.getenv("TWITTER_CONSUMER_SECRET"));
            Coordinate current = Coordinate.create(35.690921,139.700258);
            Checkin checkin = Checkin.getInstance(twitterAccount);
            List<Location> locations = checkin.getPlaces(current);
            for(Location location : locations){
                System.out.printf("country = %s, fullName = %s%n", location.getCountry(), location.getFullName());
            }
            assertNotNull(locations);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void tweet(){
        TwitterAccount twitterAccount = new TwitterAccount(
                System.getenv("TWITTER_ACCESS_TOKEN"),
                System.getenv("TWITTER_ACCESS_TOKEN_SECRET"),
                System.getenv("TWITTER_CONSUMER_KEY"),
                System.getenv("TWITTER_CONSUMER_SECRET"));
        final String country = "Nippon";
        final String fullName = "Toukyou*ChiyodaKu";
        try {
            Checkin checkin = Checkin.getInstance(twitterAccount);
            checkin.tweet(country, fullName);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}