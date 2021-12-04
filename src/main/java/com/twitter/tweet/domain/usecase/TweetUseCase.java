package com.twitter.tweet.domain.usecase;

import com.twitter.directMessage.domain.model.ReactionDomain;
import com.twitter.socialGraph.api.model.UserAPI;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.domain.port.infra.IUserInfraPort;
import com.twitter.tweet.domain.model.ReplyDomain;
import com.twitter.tweet.domain.model.ReportDomain;
import com.twitter.tweet.domain.model.TweetDomain;
import com.twitter.tweet.domain.port.api.ITweetPortToApi;
import com.twitter.tweet.domain.port.infra.ITweetPortToInfra;

public class TweetUseCase implements ITweetPortToApi {
    private ITweetPortToInfra portToInfra;
    private IUserInfraPort userInfraPort;
    @Override
    public TweetDomain likeTweet(Long tweetId, UserAPI user) {
        TweetDomain tweet = portToInfra.findTweetById(tweetId);
        ReactionDomain like = new ReactionDomain(1L,user.toDomain(),null);
        tweet.addReaction(like);
        return portToInfra.updateTweet(tweet);
    }

    @Override
    public TweetDomain dislikeTweet(Long tweetId, UserAPI user) {
        TweetDomain tweet = portToInfra.findTweetById(tweetId);
        ReactionDomain dislike = new ReactionDomain(1L,user.toDomain(),null);
        tweet.addReaction(dislike);
        return portToInfra.updateTweet(tweet);
    }

    @Override
    public UserDomain creatTweet(TweetDomain tweet) {
        portToInfra.createTweet(tweet);
        tweet.getOwner().getTweets().add(tweet);
        return userInfraPort.updateUser(tweet.getOwner());
    }

    @Override
    public void removeTweet(Long tweetId) {
        TweetDomain tweet = portToInfra.findTweetById(tweetId);
        portToInfra.removeTweet(tweet);
    }

    @Override
    public TweetDomain replyToTweet(Long tweetId, ReplyDomain reply) {
        TweetDomain tweet = portToInfra.findTweetById(tweetId);
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
