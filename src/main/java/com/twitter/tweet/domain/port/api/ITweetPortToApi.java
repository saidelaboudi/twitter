package com.twitter.tweet.domain.port.api;

import com.twitter.tweet.domain.model.ReplyDomain;
import com.twitter.tweet.domain.model.ReportDomain;
import com.twitter.tweet.domain.model.TweetDomain;

public interface ITweetPortToApi {
    TweetDomain likeTweet(Long tweetId, Long userId);

    TweetDomain dislikeTweet(Long tweetId, Long userId);

    void createTweet(TweetDomain tweet, Long userId);

    void removeTweet(Long userId, Long tweetId);

    TweetDomain replyToTweet(Long tweetId, Long userId, ReplyDomain reply);

    void shareTweet(Long tweetId, Long userId);

    void retweet(Long tweetId, Long userId);

    void reportTweet(Long tweetId, ReportDomain report);
}
