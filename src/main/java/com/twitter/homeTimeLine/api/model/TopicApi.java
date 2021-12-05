package com.twitter.homeTimeLine.api.model;

import com.twitter.directMessage.api.model.ReactionAPI;
import com.twitter.homeTimeLine.domain.model.TweetDomain;
import com.twitter.socialGraph.api.model.UserAPI;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
