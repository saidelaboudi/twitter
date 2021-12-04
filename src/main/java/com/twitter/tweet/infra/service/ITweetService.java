package com.twitter.tweet.infra.service;

import com.twitter.tweet.domain.model.TweetDomain;
import com.twitter.tweet.infra.model.Tweet;

public interface ITweetService {
    public Tweet findTweetById(Long tweetId);
    public Tweet createTweet(Tweet tweet);
    public void removeTweet(Tweet tweet);
    Tweet updateTweet(Tweet tweet);
}
