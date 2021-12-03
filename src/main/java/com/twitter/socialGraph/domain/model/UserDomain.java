package com.twitter.socialGraph.domain.model;

import com.twitter.directMessage.api.model.MessageAPI;
import com.twitter.directMessage.domain.model.MessageDomain;
import com.twitter.directMessage.infra.model.Message;
import com.twitter.socialGraph.api.model.UserAPI;
import com.twitter.socialGraph.infra.model.User;
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
    private List<MessageDomain> messages;

    public User toInfra() {
        List<Message> messages = new ArrayList<Message>();
        this.messages.forEach(message->{
            messages.add(message.toInfra());
        });
        return new User(
            this.id,
            this.username,
            this.firstname,
            this.lastname,
            this.email,
            this.phone,
            this.socialGraph.toInfra(),
                messages
        );
    }

    public void addMessage(MessageDomain message) {
        this.messages.add(message);
    }

    public UserAPI toAPI() {

        List<MessageAPI> messages = new ArrayList<MessageAPI>();
        this.messages.forEach(message->{
            messages.add(message.toApi());
        });
        return new UserAPI(
                this.id,
                this.username,
                this.firstname,
                this.lastname,
                this.email,
                this.phone,
                this.socialGraph.toAPI(),
                messages
        );
    }
}
