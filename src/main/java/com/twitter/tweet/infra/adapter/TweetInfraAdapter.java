package com.twitter.tweet.infra.adapter;

import com.twitter.tweet.domain.model.TweetDomain;
import com.twitter.tweet.domain.port.infra.ITweetPortToInfra;
import com.twitter.tweet.infra.service.ITweetService;
import org.springframework.beans.factory.annotation.Autowired;

public class TweetInfraAdapter implements ITweetPortToInfra {
    @Autowired
    private ITweetService tweetServices;

    public TweetInfraAdapter(ITweetService tweetServices) {
        this.tweetServices = tweetServices;
    }

    @Override
    public TweetDomain findTweetById(Long tweetId) {
        return tweetServices.findTweetById(tweetId).toDomain();
    }

    @Override
    public TweetDomain createTweet(TweetDomain tweet) {
        return tweetServices.createTweet(tweet.toInfra()).toDomain();
    }

    @Override
    public void removeTweet(TweetDomain tweet) {
        tweetServices.removeTweet(tweet.toInfra());
    }

    @Override
    public TweetDomain updateTweet(TweetDomain tweet) {
        return tweetServices.updateTweet(tweet.toInfra()).toDomain();
    }
}
