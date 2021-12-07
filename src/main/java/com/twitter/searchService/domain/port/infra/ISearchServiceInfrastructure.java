package com.twitter.searchService.domain.port.infra;

import com.twitter.socialGraph.domain.model.UserDomain;

import java.util.List;

public interface ISearchServiceInfrastructure  {
    public List<UserDomain> searchByUsername(String user);
    public List<UserDomain> searchByArticle(String article);
    public List<UserDomain> searchByKeyword(String keyword);
}
