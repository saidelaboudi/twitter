package com.twitter.homeTimeLine.domain.port.api;

import com.twitter.homeTimeLine.domain.model.KeyWordDomain;
import com.twitter.homeTimeLine.domain.model.TopicDomain;
import com.twitter.homeTimeLine.domain.model.TweetDomain;

import java.util.List;

public interface IHomeTimeLineApiPort {
    public List<TweetDomain> seeTweets();
    public  List<TweetDomain> explorTweetsByFilters(List<KeyWordDomain> keyWords);
    public List<TopicDomain> seeTopics();

}
