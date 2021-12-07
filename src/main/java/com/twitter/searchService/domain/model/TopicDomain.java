package com.twitter.searchService.domain.model;


import com.twitter.searchService.api.model.TopicDomainApi;
import com.twitter.searchService.infra.model.Topic;
import com.twitter.socialGraph.api.model.UserAPI;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.infra.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicDomain {
    private Long id;
    private String title;
    private String description;
    private List<String> keywords;
    private List<UserDomain> community;

    public TopicDomainApi toApi() {
        List<String> keywordsInfra= new ArrayList<String>();
        List<UserAPI> communityInfra= new ArrayList<UserAPI>();

        return new TopicDomainApi(
                this.id,
                this.title,
                this.description,
                keywordsInfra,
                communityInfra
        );
    }

    public Topic toInfra() {
        List<String> keywordsInfra= new ArrayList<String>();
        List<User> communityInfra= new ArrayList<User>();

        return new Topic(
                this.id,
                this.title,
                this.description,
                keywordsInfra,
                communityInfra
        );
    }

}