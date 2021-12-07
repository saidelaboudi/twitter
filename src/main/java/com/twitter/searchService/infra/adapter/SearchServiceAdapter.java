package com.twitter.searchService.infra.adapter;

import com.twitter.searchService.domain.port.infra.ISearchServiceInfrastructure;
import com.twitter.searchService.infra.service.ITopicService;
import com.twitter.socialGraph.domain.model.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SearchServiceAdapter implements ISearchServiceInfrastructure {

    @Autowired
    private ITopicService topicService;

    @Override
    public List<UserDomain> searchByUsername(String user) {
        return null;
    }

    @Override
    public List<UserDomain> searchByArticle(String article) {
        return null;
    }

    @Override
    public List<UserDomain> searchByKeyword(String keyword) {
        return null;
    }
}
