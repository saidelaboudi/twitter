package com.twitter.tweet.infra.service;

import com.twitter.directMessage.infra.model.Reaction;
import com.twitter.socialGraph.infra.model.User;
import com.twitter.tweet.infra.model.Tweet;

import java.util.List;

public interface ITweetService {
    public Tweet findTweetById(Long tweetId);

    public Tweet createTweet(Tweet tweet);

    public void removeTweet(Tweet tweet);

    Tweet updateTweet(Tweet tweet);

    public List<Tweet> getReTweetsAndCommentedTweetsByUser(User user);

    List<Tweet> findTweetsContains(String keyword);

    Tweet findTweetByReaction(Reaction reaction);
}
