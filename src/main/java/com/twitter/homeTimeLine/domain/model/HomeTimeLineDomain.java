package com.twitter.homeTimeLine.domain.model;


import com.twitter.homeTimeLine.api.model.HomeTimeLineAPI;
import com.twitter.homeTimeLine.infra.model.HomeTimeLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeTimeLineDomain {

    private Long id;
    private List<TweetDomain> listTweets;

    public HomeTimeLine toInfra() {
        List<Tweet> tweets = new ArrayList<>();
        this.listTweets.forEach(tweet -> {
            tweets.add(tweet.toInfra());
        });
        return new HomeTimeLine(
                this.id,
                tweets
        );
    }
    public HomeTimeLineAPI toApi() {
        List<TweetAPI> tweets = new ArrayList<>();
        this.listTweets.forEach(tweet -> {
            tweets.add(tweet.toApi());
        });

        return new HomeTimeLineAPI(this.id, tweets);
    }

}
