package com.twitter.socialGraph.domain.model;

import com.twitter.directMessage.api.model.ConversationAPI;
import com.twitter.directMessage.domain.model.ConversationDomain;
import com.twitter.directMessage.infra.model.Conversation;
import com.twitter.socialGraph.api.model.UserAPI;
import com.twitter.socialGraph.infra.model.User;
import com.twitter.tweet.api.model.TweetAPI;
import com.twitter.tweet.domain.model.TweetDomain;
import com.twitter.tweet.infra.model.Tweet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


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


    public User toInfra() {
        List<Conversation> conversations = new ArrayList<Conversation>();
        this.conversations.forEach(conversation -> {
            conversations.add(conversation.toInfra());
        });
        List<Tweet> tweets = new ArrayList<>();
        this.tweets.forEach(tweet->{
            tweets.add(tweet.toInfra());
        });

        List<Tweet> retweets = new ArrayList<>();
        this.retweets.forEach(tweet->{
            retweets.add(tweet.toInfra());
        });

        List<Tweet> shareTweets = new ArrayList<>();
        this.sharedTweets.forEach(tweet->{
            shareTweets.add(tweet.toInfra());
        });
        return new User(
                this.id,
                this.username,
                this.firstname,
                this.lastname,
                this.email,
                this.phone,
                this.socialGraph.toInfra(),
                conversations,
                tweets,
                retweets,
                shareTweets
        );
    }

    public UserAPI toAPI() {
        List<ConversationAPI> conversations = new ArrayList<>();
        this.conversations.forEach(conversation -> {
            conversations.add(conversation.toApi());
        });
        List<TweetAPI> tweets = new ArrayList<>();
        this.tweets.forEach(tweet->{
            tweets.add(tweet.toAPI());
        });

        List<TweetAPI> retweets = new ArrayList<>();
        this.retweets.forEach(tweet->{
            retweets.add(tweet.toAPI());
        });

        List<TweetAPI> shareTweets = new ArrayList<>();
        this.sharedTweets.forEach(tweet->{
            shareTweets.add(tweet.toAPI());
        });

        return new UserAPI(
                this.id,
                this.username,
                this.firstname,
                this.lastname,
                this.email,
                this.phone,
                this.socialGraph.toAPI(),
                conversations,
                tweets,
                retweets,
                shareTweets
        );
    }
}
