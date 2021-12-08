package com.twitter.tweet.infra.service.impl;

import com.twitter.directMessage.infra.model.Reaction;
import com.twitter.socialGraph.infra.model.User;
import com.twitter.tweet.infra.model.Tweet;
import com.twitter.tweet.infra.repository.TweetRepository;
import com.twitter.tweet.infra.service.ITweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        tweet.setReactions(new ArrayList<>());
        tweet.setReplies(new ArrayList<>());
        tweet.setReports(new ArrayList<>());
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

    @Override
    public List<Tweet> getReTweetsAndCommentedTweetsByUser(User user) {
        return null;
    }

    @Override
    public List<Tweet> findTweetsContains(String keyword) {
        return tweetRepository.findTweetsByTextContains(keyword);
    }

    @Override
    public Tweet findTweetByReaction(Reaction reaction) {
        return tweetRepository.findByReaction(reaction);
    }
}
