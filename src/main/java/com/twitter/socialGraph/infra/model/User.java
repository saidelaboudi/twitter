package com.twitter.socialGraph.infra.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.twitter.directMessage.domain.model.ConversationDomain;
import com.twitter.directMessage.infra.model.Conversation;
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
    @JsonFormat(timezone="UTC")
    Date createdDate ;
    @Column(name = "modified_date")
    @LastModifiedDate
    @JsonFormat(timezone="UTC")
    Date modifiedDate ;

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

    public UserDomain toDomain() {
        List<ConversationDomain> conversations = new ArrayList<>();
        this.conversations.forEach(conversation -> {
            conversations.add(conversation.toDomain());
        });


        List<TweetDomain> tweets = new ArrayList<>();
        this.tweets.forEach(tweet -> {
            tweets.add(tweet.toDomain());
        });

        List<TweetDomain> retweets = new ArrayList<>();
        this.retweets.forEach(tweet -> {
            retweets.add(tweet.toDomain());
        });

        List<TweetDomain> shareTweets = new ArrayList<>();
        this.sharedTweets.forEach(tweet -> {
            shareTweets.add(tweet.toDomain());
        });

        return new UserDomain(
                this.id,
                this.username,
                this.firstname,
                this.lastname,
                this.email,
                this.phone,
                this.socialGraph.toDomain(),
                conversations,
                tweets,
                retweets,
                shareTweets
        );
    }
}
