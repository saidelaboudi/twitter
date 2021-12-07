package com.twitter.tweet.domain.port.infra;

import com.twitter.tweet.domain.model.TweetDomain;

import java.util.List;

public interface ITweetPortToInfra {
    public TweetDomain findTweetById(Long tweetId);
    public TweetDomain createTweet(TweetDomain tweet);
    public void removeTweet(TweetDomain tweet);
    public TweetDomain updateTweet(TweetDomain tweet);

    public List<TweetDomain> getTweetsByUser(String userName);
    public List<TweetDomain> getLikedTweetsByUser(String userName);
    public List<TweetDomain> getReTweetsAndCommentedTweetsByUser(String userName);
}
