package com.latecheckin;

import twitter4j.GeoLocation;
import twitter4j.GeoQuery;
import twitter4j.Place;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Checkin {
    final String TWITTER_ACCOUNT = System.getenv("TWITTER_ACCOUNT");
    final String TWITTER_ACCESS_TOKEN = System.getenv("TWITTER_ACCESS_TOKEN");
    final String TWITTER_ACCESS_TOKEN_SECRET = System.getenv("TWITTER_ACCESS_TOKEN_SECRET");
    final String TWITTER_CONSUMER_KEY = System.getenv("TWITTER_CONSUMER_KEY");
    final String TWITTER_CONSUMER_SECRET = System.getenv("TWITTER_CONSUMER_SECRET");

    private Twitter twitter;

    public Checkin(){
        twitter = new TwitterFactory(
                new ConfigurationBuilder()
                        .setDebugEnabled(true)
                        .setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
                        .setOAuthConsumerSecret(TWITTER_CONSUMER_SECRET)
                        .setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
                        .setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET)
                        .build()).getInstance();
    }

    public ResponseList<Place> getPlaces(Location current) throws TwitterException{
        GeoLocation location = new GeoLocation(current.getLatitude(), current.getLongitude());
        GeoQuery query = new GeoQuery(location);
        return twitter.searchPlaces(query);
    }
}
