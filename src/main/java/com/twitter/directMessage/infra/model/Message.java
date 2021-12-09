package com.twitter.directMessage.infra.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.twitter.directMessage.domain.model.MessageDomain;
import com.twitter.directMessage.domain.model.ReactionDomain;
import com.twitter.socialGraph.infra.model.User;
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
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private User sender;
    private String message;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reaction> reactions;
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    @JsonFormat(timezone="UTC")
    Date createdDate ;
    @Column(name = "modified_date")
    @LastModifiedDate
    @JsonFormat(timezone="UTC")
    Date modifiedDate ;

    public Message(Long id, User sender, String message, List<Reaction> reactions) {
        this.id = id;
        this.sender = sender;
        this.message = message;
        this.reactions = reactions;
    }

    public MessageDomain toDomain() {
        List<ReactionDomain> reactions =new ArrayList<>();
        if (!this.reactions.equals(null))
            this.reactions.forEach(reaction->{
            reactions.add(reaction.toDomain());
        });
    return new MessageDomain(this.id, this.sender.toDomain(), this.message,reactions);
    }
}
