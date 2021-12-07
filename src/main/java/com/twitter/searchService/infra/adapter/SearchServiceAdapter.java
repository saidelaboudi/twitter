package com.twitter.searchService.infra.adapter;

import com.twitter.searchService.domain.port.infra.ISearchServiceInfrastructure;
import com.twitter.searchService.infra.service.ITopicService;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.domain.port.infra.IUserInfraPort;
import com.twitter.tweet.domain.model.TweetDomain;
import com.twitter.tweet.domain.port.infra.ITweetPortToInfra;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SearchServiceAdapter implements ISearchServiceInfrastructure {

    @Autowired
    private ITopicService topicService;
    @Autowired
    private IUserInfraPort userInfraPort;
    @Autowired
    private ITweetPortToInfra tweetPortToInfra;

    @Override
    public List<UserDomain> searchByUsername(String username) {
        return userInfraPort.findUsersByUsernameContains(username);
    }

    @Override
    public List<UserDomain> searchByArticle(String article) {
        return null;
    }

    @Override
    public List<TweetDomain> searchTweetByKeyword(String keyword) {
        return tweetPortToInfra.getTweetsByKeyword(keyword);
    }
}
