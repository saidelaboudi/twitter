package com.twitter.searchService.api.model;

import com.twitter.socialGraph.api.model.UserAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicDomainApi {
    private Long id;
    private String title;
    private String description;
    private List<String> keywords;
    private List<UserAPI> community;
}
