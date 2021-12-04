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
    public void likeTweet(Long tweetId, UserAPI user) {
        TweetDomain tweet = portToInfra.findTweetById(tweetId).toDomain();
        ReactionDomain like = new ReactionDomain();
        tweet.addReaction(like);
    }

    @Override
    public void dislikeTweet(Long tweetId, UserAPI user) {
        TweetDomain tweet = portToInfra.findTweetById(tweetId).toDomain();
        ReactionDomain dislike = new ReactionDomain();
        tweet.addReaction(dislike);
    }

    @Override
    public void creatTweet(TweetDomain tweet) {
        portToInfra.createTweet(tweet);
    }

    @Override
    public void removeTweet(Long tweetId) {
        TweetDomain tweet = portToInfra.findTweetById(tweetId).toDomain();
        portToInfra.removeTweet(tweet);
    }

    @Override
    public void replyToTweet(Long tweetId, ReplyDomain reply) {
        TweetDomain tweet = portToInfra.findTweetById(tweetId).toDomain();
        tweet.addReply(reply);
    }

    @Override
    public void shareTweet(Long tweetId, Long userId) {
        TweetDomain tweet = portToInfra.findTweetById(tweetId).toDomain();
        UserDomain user = userInfraPort.findUserById(userId);
        user.addSahredTweet(tweet);
    }

    @Override
    public void retweet(Long tweetId, Long userId) {
        TweetDomain tweet = portToInfra.findTweetById(tweetId).toDomain();
        UserDomain user = userInfraPort.findUserById(userId);
        user.retweet(tweet);
    }

    @Override
    public void reportTweet(Long tweetId, Long userId, ReportDomain report) {
        TweetDomain tweet = portToInfra.findTweetById(tweetId).toDomain();
        UserDomain user = userInfraPort.findUserById(userId);
        tweet.report(user,report);
    }
}
