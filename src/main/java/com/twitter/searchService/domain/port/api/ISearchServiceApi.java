package com.twitter.searchService.domain.port.api;


import com.twitter.socialGraph.domain.model.UserDomain;

import java.util.List;

public interface ISearchServiceApi {
    public List<UserDomain> searchByUsername(String user);
    public List<UserDomain> searchByArticle(String article);
    public List<UserDomain> searchByKeyword(String keyword);
}
