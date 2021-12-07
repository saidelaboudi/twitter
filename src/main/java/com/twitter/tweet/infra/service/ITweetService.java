package com.twitter.tweet.infra.service;

import com.twitter.tweet.infra.model.Tweet;

import java.util.List;

public interface ITweetService {
    public Tweet findTweetById(Long tweetId);
    public Tweet createTweet(Tweet tweet);
    public void removeTweet(Tweet tweet);
    Tweet updateTweet(Tweet tweet);
    public List<Tweet> getTweetsByUser(Long userId);
    public List<Tweet> getLikedTweetsByUser(Long userId);
    public List<Tweet> getReTweetsAndCommentedTweetsByUser(Long userId);
}
