package com.twitter.tweet.domain.port.api;

import com.twitter.socialGraph.api.model.UserAPI;
import com.twitter.tweet.domain.model.ReplyDomain;
import com.twitter.tweet.domain.model.ReportDomain;
import com.twitter.tweet.domain.model.TweetDomain;

public interface ITweetPortToApi {
    void likeTweet(Long tweetId, UserAPI user);
    void dislikeTweet(Long tweetId, UserAPI user);
    void creatTweet(TweetDomain tweet);
    void removeTweet(Long tweetId);
    TweetDomain replyToTweet(Long tweetId, ReplyDomain reply);
    void shareTweet(Long tweetId, Long userId);
    void retweet(Long tweetId, Long userId);
    void reportTweet(Long tweetId, Long userId, ReportDomain report);
}
