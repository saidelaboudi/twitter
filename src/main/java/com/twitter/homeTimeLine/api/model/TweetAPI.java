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
public class TweetAPI {
    private Long id;
    private UserAPI owner;
    private List<ReactionAPI> reactions;
    private List<Object> replies;
    private List<Object> reports;

    public TweetDomain toDomain() {
        return null;
    }
}
