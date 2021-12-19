package com.twitter.searchService.domain.port.api;


import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.tweet.domain.model.TweetDomain;

import java.util.List;

public interface ISearchServiceApi {
    public List<UserDomain> searchByUsername(String user);
    public List<TweetDomain> searchByKeyword(String keyword);
}
