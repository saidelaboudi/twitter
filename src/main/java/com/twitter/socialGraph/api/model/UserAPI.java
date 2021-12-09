package com.twitter.socialGraph.api.model;

import com.twitter.directMessage.api.model.ConversationAPI;
import com.twitter.homeTimeLine.api.model.TopicApi;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.tweet.api.model.TweetAPI;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAPI {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private SocialGraphAPI socialGraph = new SocialGraphAPI();
    private List<ConversationAPI> conversations = new ArrayList<ConversationAPI>();
    private List<TweetAPI> tweets = new ArrayList<TweetAPI>();
    private List<TweetAPI> retweets = new ArrayList<TweetAPI>();
    private List<TweetAPI> sharedTweets= new ArrayList<TweetAPI>();
    private List<TopicApi> topics = new ArrayList<>();


    public UserDomain toDomain() {
        return new UserDomain(
                this.id,
                this.username,
                this.firstname,
                this.lastname,
                this.email,
                this.phone,
                this.socialGraph.toDomain(),
                this.conversations.stream().map(ConversationAPI::toDomain).collect(Collectors.toList()),
                this.tweets.stream().map(TweetAPI::toDomain).collect(Collectors.toList()),
                this.retweets.stream().map(TweetAPI::toDomain).collect(Collectors.toList()),
                this.sharedTweets.stream().map(TweetAPI::toDomain).collect(Collectors.toList()),
                this.topics.stream().map(TopicApi::toDomain).collect(Collectors.toList())
        );
    }
}
