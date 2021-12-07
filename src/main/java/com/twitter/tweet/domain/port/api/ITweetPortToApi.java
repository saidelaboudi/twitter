package com.twitter.tweet.domain.port.api;

import com.twitter.tweet.domain.model.ReplyDomain;
import com.twitter.tweet.domain.model.ReportDomain;
import com.twitter.tweet.domain.model.TweetDomain;

import java.util.List;

public interface ITweetPortToApi {
    TweetDomain likeTweet(Long tweetId, Long userId);
    TweetDomain dislikeTweet(Long tweetId, Long userId);
    void createTweet(TweetDomain tweet, Long userId);
    void removeTweet(Long tweetId);
    TweetDomain replyToTweet(Long tweetId, ReplyDomain reply);
    void shareTweet(Long tweetId, Long userId);
    void retweet(Long tweetId, Long userId);
    void reportTweet(Long tweetId,ReportDomain report);
    List<TweetDomain> viewTweetsByUser(String userName);
    List<TweetDomain> viewLikedTweetsByUser(String userName);
    List<TweetDomain> viewReTweetsAndCommentedTweetsByUser(String userName);
}
