package com.latecheckin;

import java.util.ArrayList;
import java.util.List;

import twitter4j.GeoLocation;
import twitter4j.GeoQuery;
import twitter4j.Place;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Checkin {
    private static Checkin checkin = null;
    private Twitter twitter;

    private Checkin(TwitterAccount twitterAccount){
        twitter = new TwitterFactory(
                new ConfigurationBuilder()
                        .setDebugEnabled(true)
                        .setOAuthConsumerKey(twitterAccount.getConsumerKey())
                        .setOAuthConsumerSecret(twitterAccount.getConsumerSecret())
                        .setOAuthAccessToken(twitterAccount.getAccessToken())
                        .setOAuthAccessTokenSecret(twitterAccount.getAccessTokenSecret())
                        .build()).getInstance();
    }

    public static Checkin getInstance(TwitterAccount twitterAccount){
        if(checkin  == null){
            checkin = new Checkin(twitterAccount);
        }
        return checkin;
    }

    public List<Location> getPlaces(DeviceLocation.Coordinate current) throws TwitterException{
        GeoLocation geoLocation = new GeoLocation(current.getLatitude(), current.getLongitude());
        GeoQuery query = new GeoQuery(geoLocation);
        ResponseList<Place> places = twitter.searchPlaces(query);
        List<Location> locations = new ArrayList<Location>();
        for(Place place : places){
            locations.add(Location.create(place));
        }
        return locations;
    }

    public void tweet(String country, String fullName) throws TwitterException {
        String message = String.format("I'm at, %s, %s.", fullName, country);
        twitter.updateStatus(message);
    }
}
