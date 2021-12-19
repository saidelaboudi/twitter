package com.twitter.homeTimeLine.api.model;

import com.twitter.homeTimeLine.domain.model.TopicDomain;
import com.twitter.tweet.api.model.TweetAPI;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicApi {
    private Long id;
    private List<TweetAPI> tweets;

    public TopicDomain toDomain() {
        return new TopicDomain(
                this.id,
                this.tweets.stream().map(TweetAPI::toDomain).collect(Collectors.toList())
        );
    }
}
