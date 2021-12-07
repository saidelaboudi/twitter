package com.twitter.tweet.infra.adapter;

import com.twitter.tweet.domain.model.TweetDomain;
import com.twitter.tweet.domain.port.infra.ITweetPortToInfra;
import com.twitter.tweet.infra.service.ITweetService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TweetInfraAdapter implements ITweetPortToInfra {
    @Autowired
    private ITweetService tweetServices;

    public TweetInfraAdapter(ITweetService tweetServices) {
        this.tweetServices = tweetServices;
    }

    @Override
    public TweetDomain findTweetById(Long tweetId) {
        return tweetServices.findTweetById(tweetId).toDomain();
    }

    @Override
    public TweetDomain createTweet(TweetDomain tweet) {
        return tweetServices.createTweet(tweet.toInfra()).toDomain();
    }

    @Override
    public void removeTweet(TweetDomain tweet) {
        tweetServices.removeTweet(tweet.toInfra());
    }

    @Override
    public TweetDomain updateTweet(TweetDomain tweet) {
        return tweetServices.updateTweet(tweet.toInfra()).toDomain();
    }

    @Override
    public List<TweetDomain> getTweetsByUser(String userName) {
        List<TweetDomain> tweets = new ArrayList<TweetDomain>();
        tweetServices.getTweetsByUser(userName).forEach(tweet -> {
            tweets.add(tweet.toDomain());
        });
        return tweets;
    }

    @Override
    public List<TweetDomain> getLikedTweetsByUser(String userName) {
        List<TweetDomain> tweets = new ArrayList<TweetDomain>();
        tweetServices.getLikedTweetsByUser(userName).forEach(tweet -> {
            tweets.add(tweet.toDomain());
        });
        return tweets;
    }

    @Override
    public List<TweetDomain> getReTweetsAndCommentedTweetsByUser(String userName) {
        List<TweetDomain> tweets = new ArrayList<TweetDomain>();
        tweetServices.getReTweetsAndCommentedTweetsByUser(userName).forEach(tweet -> {
            tweets.add(tweet.toDomain());
        });
        return tweets;
    }
}
