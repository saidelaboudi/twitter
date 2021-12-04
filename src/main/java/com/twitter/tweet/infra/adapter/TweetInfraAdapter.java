package com.twitter.tweet.infra.adapter;

import com.twitter.tweet.domain.model.TweetDomain;
import com.twitter.tweet.domain.port.infra.ITweetPortToInfra;
import com.twitter.tweet.infra.model.Tweet;
import com.twitter.tweet.infra.service.ITweetService;
import org.springframework.beans.factory.annotation.Autowired;

public class TweetInfraAdapter implements ITweetPortToInfra {
    @Autowired
    private ITweetService tweetServices;
    @Override
    public Tweet findTweetById(Long tweetId) {
        return tweetServices.findTweetById(tweetId);
    }

    @Override
    public void createTweet(TweetDomain tweet) {
        tweetServices.createTweet(tweet.toInfra());
    }

    @Override
    public void removeTweet(TweetDomain tweet) {
        tweetServices.removeTweet(tweet.toInfra());
    }
}
