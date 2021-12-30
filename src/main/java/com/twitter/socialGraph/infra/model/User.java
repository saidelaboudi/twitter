package com.twitter.socialGraph.infra.model;

import com.twitter.directMessage.domain.model.ConversationDomain;
import com.twitter.directMessage.infra.model.Conversation;
import com.twitter.homeTimeLine.domain.model.TopicDomain;
import com.twitter.homeTimeLine.infra.model.Topic;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.tweet.domain.model.TweetDomain;
import com.twitter.tweet.infra.model.Tweet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    @OneToOne(cascade = CascadeType.ALL)
    private SocialGraph socialGraph;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Conversation> conversations;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Tweet> tweets;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Tweet> retweets;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Tweet> sharedTweets;
    @OneToMany
    private List<Topic> topics = new ArrayList<Topic>();


    public UserDomain toDomain() {
        return new UserDomain(
                this.id,
                this.username,
                this.firstname,
                this.lastname,
                this.email,
                this.phone,
                this.socialGraph.toDomain(),
                this.conversations==null? null : this.conversations.stream().map(Conversation::toDomain).collect(Collectors.toList()),
                this.tweets==null ? null : this.tweets.stream().map(Tweet::toDomain).collect(Collectors.toList()),
                this.retweets==null? null : this.retweets.stream().map(Tweet::toDomain).collect(Collectors.toList()),
                this.sharedTweets==null? null : this.sharedTweets.stream().map(Tweet::toDomain).collect(Collectors.toList()),
                this.topics==null? null : this.topics.stream().map(Topic::toDomain).collect(Collectors.toList())
        );
    }
}
