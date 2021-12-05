package com.twitter.socialGraph.api.model;

import com.twitter.directMessage.api.model.ConversationAPI;
import com.twitter.directMessage.api.model.MessageAPI;
import com.twitter.directMessage.domain.model.ConversationDomain;
import com.twitter.directMessage.domain.model.MessageDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.tweet.api.model.TweetAPI;
import com.twitter.tweet.domain.model.TweetDomain;
import com.twitter.tweet.infra.model.Tweet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


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


    public UserDomain toDomain() {
        List<ConversationDomain> conversations = new ArrayList<>();
        if (!this.conversations.isEmpty())
            this.conversations.forEach(conversation -> {
                conversations.add(conversation.toDomain());
            });


        List<TweetDomain> tweets = new ArrayList<>();
        if (!this.tweets.isEmpty())
            this.tweets.forEach(tweet -> {
                tweets.add(tweet.toDomain());
            });

        List<TweetDomain> retweets = new ArrayList<>();
        if (!this.retweets.isEmpty())
            this.retweets.forEach(tweet -> {
                    retweets.add(tweet.toDomain());
            });

        List<TweetDomain> shareTweets = new ArrayList<>();
        if (!this.sharedTweets.isEmpty())
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
