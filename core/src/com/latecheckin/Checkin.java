package com.latecheckin;

import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.Query;

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

    public void getLocations(){
        System.out.println("----- getLocations start. -----");

        String queryStr = "car";
        Query query = new Query();
        query.setQuery(queryStr);
        try {
            QueryResult result = twitter.search(query);
            for (Status s : result.getTweets()) {
                System.out.println(s.getText());
            }
        } catch (TwitterException e) {
            System.out.println("error raise.");
            System.out.println(e);
        }

        System.out.println("----- getLocations end. -----");
    }
}
