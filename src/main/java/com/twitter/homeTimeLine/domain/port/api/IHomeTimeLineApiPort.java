package com.twitter.homeTimeLine.domain.port.api;

import com.twitter.homeTimeLine.domain.model.KeyWordDomain;
import com.twitter.homeTimeLine.domain.model.TopicDomain;
import com.twitter.tweet.api.model.TweetAPI;

import java.util.List;

public interface IHomeTimeLineApiPort {
    List<TweetAPI> getAllHomeTimeLineTweets(Long userId);
}
