package com.twitter.socialGraph.domain.model;

import com.twitter.directMessage.api.model.MessageAPI;
import com.twitter.directMessage.domain.model.MessageDomain;
import com.twitter.directMessage.infra.model.Message;
import com.twitter.socialGraph.api.model.UserAPI;
import com.twitter.socialGraph.infra.model.User;
import com.twitter.tweet.domain.model.TweetDomain;
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
    private List<MessageDomain> messagesSent;
    private List<MessageDomain> messagesReceived;

    public User toInfra() {
        List<Message> messagesSent = new ArrayList<Message>();
        List<Message> messagesReceived = new ArrayList<Message>();
        this.messagesSent.forEach(message -> {
            messagesSent.add(message.toInfra());
        });
        this.messagesReceived.forEach(message -> {
            messagesReceived.add(message.toInfra());
        });
        return new User(
                this.id,
                this.username,
                this.firstname,
                this.lastname,
                this.email,
                this.phone,
                this.socialGraph.toInfra(),
                messagesSent,
                messagesReceived
        );
    }

    public void addMessage(MessageDomain message) {
        this.messagesReceived.add(message);
    }

    public UserAPI toAPI() {
        List<MessageAPI> messagesSent = new ArrayList<MessageAPI>();
        List<MessageAPI> messagesReceived = new ArrayList<MessageAPI>();
        this.messagesSent.forEach(message -> {
            messagesSent.add(message.toApi());
        });
        this.messagesReceived.forEach(message -> {
            messagesReceived.add(message.toApi());
        });
        return new UserAPI(
                this.id,
                this.username,
                this.firstname,
                this.lastname,
                this.email,
                this.phone,
                this.socialGraph.toAPI(),
                messagesSent,
                messagesReceived
        );
    }

    public void addSahredTweet(TweetDomain tweet) {
    }

    public void retweet(TweetDomain tweet) {
    }
}
