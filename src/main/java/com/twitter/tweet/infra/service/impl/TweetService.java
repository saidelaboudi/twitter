package com.twitter.tweet.infra.service.impl;

import com.twitter.tweet.domain.model.TweetDomain;
import com.twitter.tweet.infra.model.Tweet;
import com.twitter.tweet.infra.repository.TweetRepository;
import com.twitter.tweet.infra.service.ITweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetService implements ITweetService {
    @Autowired
    private TweetRepository tweetRepository;

    @Override
    public Tweet findTweetById(Long tweetId) {
        return tweetRepository.findById(tweetId).get();
    }

    @Override
    public Tweet createTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @Override
    public void removeTweet(Tweet tweet) {
        tweetRepository.delete(tweet);
    }

    @Override
    public Tweet updateTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }
}
