package com.twitter.socialGraph.domain.model;

import com.twitter.directMessage.domain.model.ConversationDomain;
import com.twitter.homeTimeLine.domain.model.TopicDomain;
import com.twitter.socialGraph.api.model.UserAPI;
import com.twitter.socialGraph.infra.model.User;
import com.twitter.tweet.domain.model.TweetDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDomain {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private SocialGraphDomain socialGraph;
    private List<ConversationDomain> conversations;
    private List<TweetDomain> tweets;
    private List<TweetDomain> retweets;
    private List<TweetDomain> sharedTweets;
    private List<TopicDomain> topics = new ArrayList<>();


    public User toInfra() {
        return new User(
                this.id,
                this.username,
                this.firstname,
                this.lastname,
                this.email,
                this.phone,
                this.socialGraph.toInfra(),
                this.conversations.stream().map(ConversationDomain::toInfra).collect(Collectors.toList()),
                this.tweets.stream().map(TweetDomain::toInfra).collect(Collectors.toList()),
                this.retweets.stream().map(TweetDomain::toInfra).collect(Collectors.toList()),
                this.sharedTweets.stream().map(TweetDomain::toInfra).collect(Collectors.toList()),
                this.topics.stream().map(TopicDomain::toInfra).collect(Collectors.toList())
        );
    }

    public UserAPI toAPI() {
        return new UserAPI(
                this.id,
                this.username,
                this.firstname,
                this.lastname,
                this.email,
                this.phone,
                this.socialGraph.toAPI(),
                this.conversations.stream().map(ConversationDomain::toApi).collect(Collectors.toList()),
                this.tweets.stream().map(TweetDomain::toAPI).collect(Collectors.toList()),
                this.retweets.stream().map(TweetDomain::toAPI).collect(Collectors.toList()),
                this.sharedTweets.stream().map(TweetDomain::toAPI).collect(Collectors.toList()),
                this.topics.stream().map(TopicDomain::toAPI).collect(Collectors.toList())
        );
    }
}
