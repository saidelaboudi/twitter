package com.twitter.tweet.domain.usecase;

import com.twitter.directMessage.domain.model.ReactionDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.domain.port.service.IUserTweeterPort;
import com.twitter.tweet.domain.model.ReplyDomain;
import com.twitter.tweet.domain.model.ReportDomain;
import com.twitter.tweet.domain.model.TweetDomain;
import com.twitter.tweet.domain.port.api.ITweetPortToApi;
import com.twitter.tweet.domain.port.infra.ITweetPortToInfra;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


public class TweetUseCase implements ITweetPortToApi {
    @Autowired
    private ITweetPortToInfra portToInfra;
    @Autowired
    private IUserTweeterPort userInfraPort;

    public TweetUseCase(ITweetPortToInfra portToInfra, IUserTweeterPort userInfraPort) {
        this.portToInfra = portToInfra;
        this.userInfraPort = userInfraPort;
    }

    @Override
    public TweetDomain likeTweet(Long tweetId, Long userId) {
        UserDomain user = userInfraPort.findUserById(userId);
        TweetDomain tweet = portToInfra.findTweetById(tweetId);
        ReactionDomain like = new ReactionDomain(1L, user);
        tweet.addReaction(like);
        return portToInfra.updateTweet(tweet);
    }

    @Override
    public TweetDomain dislikeTweet(Long tweetId, Long userId) {
        UserDomain user = userInfraPort.findUserById(userId);
        TweetDomain tweet = portToInfra.findTweetById(tweetId);
        ReactionDomain dislike = new ReactionDomain(1L, user);
        tweet.addReaction(dislike);
        return portToInfra.updateTweet(tweet);
    }

    @Override
    public void createTweet(TweetDomain tweet, Long userId) {
        UserDomain user = userInfraPort.findUserById(userId);
        tweet.setReplies(new ArrayList<>());
        tweet.setReports(new ArrayList<>());
        tweet.setReactions(new ArrayList<>());
        user.getTweets().add(tweet);
        userInfraPort.updateUser(user);
    }

    @Override
    public void removeTweet(Long userId, Long tweetId) {
        UserDomain user = userInfraPort.findUserById(userId);
        TweetDomain tweet = portToInfra.findTweetById(tweetId);
        user.getTweets().remove(tweet);
        userInfraPort.updateUser(user);
    }

    @Override
    public TweetDomain replyToTweet(Long tweetId, Long userId, ReplyDomain reply) {
        TweetDomain tweet = portToInfra.findTweetById(tweetId);
        reply.setUser(userInfraPort.findUserById(userId));
        tweet.addReply(reply);
        return portToInfra.updateTweet(tweet);
    }

    @Override
    public void shareTweet(Long tweetId, Long userId) {
        TweetDomain tweet = portToInfra.findTweetById(tweetId);
        UserDomain user = userInfraPort.findUserById(userId);
        user.getSharedTweets().add(tweet);
        userInfraPort.updateUser(user);
    }

    @Override
    public void retweet(Long tweetId, Long userId) {
        TweetDomain tweet = portToInfra.findTweetById(tweetId);
        UserDomain user = userInfraPort.findUserById(userId);
        user.getRetweets().add(tweet);
        userInfraPort.updateUser(user);
    }

    @Override
    public void reportTweet(Long tweetId, ReportDomain report) {
        TweetDomain tweet = portToInfra.findTweetById(tweetId);
        tweet.getReports().add(report);
    }

}
