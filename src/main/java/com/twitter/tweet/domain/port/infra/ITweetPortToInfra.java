package com.twitter.tweet.domain.port.infra;

import com.twitter.tweet.domain.model.TweetDomain;

public interface ITweetPortToInfra {
    public TweetDomain findTweetById(Long tweetId);
    public TweetDomain createTweet(TweetDomain tweet);
    public void removeTweet(TweetDomain tweet);
    public TweetDomain updateTweet(TweetDomain tweet);
}
