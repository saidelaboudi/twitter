package com.twitter.userTimeLineService.infra.adapter;

import com.twitter.userTimeLineService.domain.model.TweetsDomain;
import com.twitter.userTimeLineService.domain.port.infra.IUserTimeLineInfraPort;
import com.twitter.userTimeLineService.infra.service.IUserTimeLineService;

import java.util.ArrayList;
import java.util.List;

public class UserTimeLineInfraPortAdapter implements IUserTimeLineInfraPort {
    IUserTimeLineService userTimeLineService;

    @Override
    public List<TweetsDomain> getTweetsByUser(String userName) {
        List<TweetsDomain> tweets = new ArrayList<TweetsDomain>();
        userTimeLineService.getTweetsByUser(userName).forEach(tweet -> {
            tweets.add(tweet.toDomain());
        });
        return tweets;
    }

    @Override
    public List<TweetsDomain> getLikedTweetsByUser(String userName) {
        return null;
    }

    @Override
    public List<TweetsDomain> getReTweetsAndCommentedTweetsByUser(String userName) {
        return null;
    }
}
