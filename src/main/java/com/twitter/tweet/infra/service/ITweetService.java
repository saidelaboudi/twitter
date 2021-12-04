package com.twitter.tweet.infra.service;

import com.twitter.tweet.infra.model.Tweet;

public interface ITweetService {
    public Tweet findTweetById(Long tweetId);
    public void createTweet(Tweet toInfra);
    public void removeTweet(Tweet toInfra);
}
