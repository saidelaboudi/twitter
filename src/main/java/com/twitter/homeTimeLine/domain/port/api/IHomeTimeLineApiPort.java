package com.twitter.homeTimeLine.domain.port.api;

import com.twitter.tweet.domain.model.TweetDomain;

import java.util.List;

public interface IHomeTimeLineApiPort {
    List<TweetDomain> getAllHomeTimeLineTweets(Long userId);
    List<TweetDomain> getTweetsByFollowedTopicsOfUser(Long userId);
}
