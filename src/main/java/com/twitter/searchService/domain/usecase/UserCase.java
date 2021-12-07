package com.twitter.searchService.domain.usecase;

import com.twitter.searchService.domain.port.api.ISearchServiceApi;
import com.twitter.searchService.domain.port.infra.ISearchServiceInfrastructure;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.tweet.domain.model.TweetDomain;

import java.util.List;

public class UserCase implements ISearchServiceApi {
    private ISearchServiceInfrastructure iSearchServiceInfrastructure;

    @Override
    public List<UserDomain> searchByUsername(String username) {
        return iSearchServiceInfrastructure.searchByUsername(username);
    }

    @Override
    public List<UserDomain> searchByArticle(String article) {
        return iSearchServiceInfrastructure.searchByArticle(article);
    }

    @Override
    public List<TweetDomain> searchByKeyword(String keyword) {
        return iSearchServiceInfrastructure.searchTweetByKeyword(keyword);
    }

}
