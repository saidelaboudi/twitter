package com.twitter.socialGraph.api.model;

import com.twitter.directMessage.api.model.ConversationAPI;
import com.twitter.homeTimeLine.api.model.TopicApi;
import com.twitter.socialGraph.domain.model.SocialGraphDomain;
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
    private List<ConversationAPI> conversations;
    private List<TweetAPI> tweets ;
    private List<TweetAPI> retweets;
    private List<TweetAPI> sharedTweets;
    private List<TopicApi> topics;


    public UserDomain toDomain() {
        return new UserDomain(
                this.id,
                this.username,
                this.firstname,
                this.lastname,
                this.email,
                this.phone,
                this.conversations==null?null:this.conversations.stream().map(ConversationAPI::toDomain).collect(Collectors.toList()),
                this.tweets==null?null:this.tweets.stream().map(TweetAPI::toDomain).collect(Collectors.toList()),
                this.retweets==null?null:this.retweets.stream().map(TweetAPI::toDomain).collect(Collectors.toList()),
                this.sharedTweets==null?null:this.sharedTweets.stream().map(TweetAPI::toDomain).collect(Collectors.toList()),
                this.topics==null?null:this.topics.stream().map(TopicApi::toDomain).collect(Collectors.toList())
        );
    }
}
