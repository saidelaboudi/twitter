package com.twitter.homeTimeLine.infra.service;

import com.twitter.homeTimeLine.domain.model.KeyWordDomain;
import com.twitter.homeTimeLine.infra.model.KeyWord;
import com.twitter.homeTimeLine.infra.model.Tweet;

import java.util.List;

public interface IHomeTimeLineService {

        public List<Tweet> seeTweets();
        public List<Tweet> explorTweetsByFilters(List<KeyWord> keyWords);
        public List<Tweet> seeTopics();

}
