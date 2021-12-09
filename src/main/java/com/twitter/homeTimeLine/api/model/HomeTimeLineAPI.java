package com.twitter.homeTimeLine.api.model;

<<<<<<< HEAD
import com.twitter.directMessage.domain.model.MessageDomain;
import com.twitter.directMessage.domain.model.ReactionDomain;
import com.twitter.homeTimeLine.domain.model.HomeTimeLineDomain;
import com.twitter.homeTimeLine.domain.model.TweetDomain;
=======
>>>>>>> c77fa98 (add architecture service)
import com.twitter.socialGraph.api.model.UserAPI;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeTimeLineAPI {

    private Long id;
    private List<TweetAPI> listTweets;

    public HomeTimeLineDomain toDomain() {
        List<TweetDomain> tweets = new ArrayList<>();
        this.listTweets.forEach(tweet -> {
            tweets.add(tweet.toDomain());
        });
        return new HomeTimeLineDomain(this.id,tweets);
    }

}
