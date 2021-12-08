package com.twitter.tweet.infra.adapter;

import com.twitter.directMessage.infra.model.Reaction;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.domain.port.infra.IUserInfraPort;
import com.twitter.tweet.domain.model.TweetDomain;
import com.twitter.tweet.domain.port.infra.ITweetPortToInfra;
import com.twitter.tweet.infra.model.Tweet;
import com.twitter.tweet.infra.service.ITweetService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class TweetInfraAdapter implements ITweetPortToInfra {
    @Autowired
    private ITweetService tweetServices;
    @Autowired
    private IUserInfraPort userInfraPort;

    public TweetInfraAdapter(ITweetService tweetServices) {
        this.tweetServices=tweetServices;
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
    public List<TweetDomain> getTweetsByUser(Long userId) {
        return userInfraPort.findUserById(userId).getTweets();
    }

    @Override
    public List<TweetDomain> getReTweetsAndCommentedTweetsByUser(Long userId) {
        UserDomain user = userInfraPort.findUserById(userId);
        return tweetServices.getReTweetsAndCommentedTweetsByUser(user.toInfra()).stream().map(Tweet::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<TweetDomain> getTweetsByKeyword(String keyword) {
        return tweetServices.findTweetsContains(keyword).stream().map(Tweet::toDomain).collect(Collectors.toList());
    }

    @Override
    public TweetDomain getLikedTweetsByUserReaction(Reaction reaction) {
        return tweetServices.findTweetByReaction(reaction).toDomain();
    }

}
