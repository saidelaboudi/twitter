package com.twitter.homeTimeLine.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicApi {
    private Long id;
    private String description;

    public TweetDomain toDomain() {
        return null;
    }
}
