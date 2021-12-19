package com.twitter.homeTimeLine.domain.model;

import com.twitter.homeTimeLine.api.model.TopicApi;
import com.twitter.homeTimeLine.infra.model.Topic;
import com.twitter.tweet.domain.model.TweetDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicDomain {
    private Long id;
    private List<TweetDomain> tweets;

    public Topic toInfra() {
        return new Topic(
                this.id,
                this.tweets.stream().map(TweetDomain::toInfra).collect(Collectors.toList())
        );
    }

    public TopicApi toAPI() {
        return new TopicApi(
                this.id,
                this.tweets.stream().map(TweetDomain::toAPI).collect(Collectors.toList())
        );
    }
}
