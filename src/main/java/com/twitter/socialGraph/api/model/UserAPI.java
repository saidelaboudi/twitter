package com.twitter.socialGraph.api.model;

import com.twitter.directMessage.api.model.MessageAPI;
import com.twitter.directMessage.domain.model.MessageDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private SocialGraphAPI socialGraph;
    private List<MessageAPI> messages;

    public UserDomain toDomain() {
        List<MessageDomain> messages = new ArrayList<MessageDomain>();
        this.messages.forEach(message->{
            messages.add(message.toDomain());
        });
        return new UserDomain(
                this.id,
                this.username,
                this.firstname,
                this.lastname,
                this.email,
                this.phone,
                this.socialGraph.toDomain(),
                messages
        );
    }
}
