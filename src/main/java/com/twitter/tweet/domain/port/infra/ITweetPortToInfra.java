package com.twitter.tweet.domain.port.infra;

import com.twitter.tweet.domain.model.TweetDomain;
import com.twitter.tweet.infra.model.Tweet;

public interface ITweetPortToInfra {
    Tweet findTweetById(Long tweetId);

    void createTweet(TweetDomain tweet);

    void removeTweet(TweetDomain tweet);
}
