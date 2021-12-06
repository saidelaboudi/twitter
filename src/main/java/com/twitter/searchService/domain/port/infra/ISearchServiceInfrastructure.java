package com.twitter.searchService.domain.port.infra;

import com.twitter.searchService.domain.model.TopicDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.tweet.domain.model.TweetDomain;

import java.util.List;

public interface ISearchServiceInfrastructure  {
    public List<UserDomain> searchByUsername(String user);
    public List<TweetDomain> searchTweetByKeyword(String keyword);
}
