package com.twitter.directMessage.infra.model;

import com.twitter.directMessage.domain.model.MessageDomain;
import com.twitter.directMessage.domain.model.ReactionDomain;
import com.twitter.socialGraph.infra.model.User;
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
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User sender;
    private String message;
    @OneToMany
    private List<Reaction> reactions;

    public MessageDomain toDomain() {
        List<ReactionDomain> reactions =new ArrayList<>();
        this.reactions.forEach(reaction->{
            reactions.add(reaction.toDomain());
        });
    return new MessageDomain(this.id, this.sender.toDomain(), this.message,reactions);
    }
}
