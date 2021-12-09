package com.twitter.socialGraph.infra.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
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
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    @JsonFormat(timezone = "UTC")
    Date createdDate;
    @Column(name = "modified_date")
    @LastModifiedDate
    @JsonFormat(timezone = "UTC")
    Date modifiedDate;
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

    public User(Long id, String username, String firstname, String lastname, String email, String phone, SocialGraph socialGraph, List<Conversation> conversations, List<Tweet> tweets, List<Tweet> retweets, List<Tweet> sharedTweets, List<Topic> topics) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.socialGraph = socialGraph;
        this.conversations = conversations;
        this.tweets = tweets;
        this.retweets = retweets;
        this.sharedTweets = sharedTweets;
        this.topics = topics;
    }

    public UserDomain toDomain() {
        return new UserDomain(
                this.id,
                this.username,
                this.firstname,
                this.lastname,
                this.email,
                this.phone,
                this.socialGraph.toDomain(),
                this.conversations.stream().map(Conversation::toDomain).collect(Collectors.toList()),
                this.tweets.stream().map(Tweet::toDomain).collect(Collectors.toList()),
                this.retweets.stream().map(Tweet::toDomain).collect(Collectors.toList()),
                this.sharedTweets.stream().map(Tweet::toDomain).collect(Collectors.toList()),
                this.topics.stream().map(Topic::toDomain).collect(Collectors.toList())
        );
    }
}
