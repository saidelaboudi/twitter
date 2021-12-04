package com.twitter.socialGraph.infra.model;

import com.twitter.directMessage.domain.model.MessageDomain;
import com.twitter.directMessage.infra.model.Message;
import com.twitter.socialGraph.domain.model.UserDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    @OneToOne
    private SocialGraph socialGraph;
    @OneToMany
    private List<Message> messagesSent;
    @OneToMany
    private List<Message> messagesReceived;

    public UserDomain toDomain() {
        List<MessageDomain> messagesSent = new ArrayList<MessageDomain>();
        List<MessageDomain> messagesReceived = new ArrayList<MessageDomain>();
        this.messagesSent.forEach(message->{
            messagesSent.add(message.toDomain());
        });
        this.messagesReceived.forEach(message->{
            messagesReceived.add(message.toDomain());
        });

        return new UserDomain(
                this.id,
                this.username,
                this.firstname,
                this.lastname,
                this.email,
                this.phone,
                this.socialGraph.toDomain(),
                messagesSent,
                messagesReceived
        );
    }
}
