package com.twitter.directMessage.infra.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.twitter.directMessage.domain.model.ConversationDomain;
import com.twitter.directMessage.domain.model.MessageDomain;
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
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> messages;
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    @JsonFormat(timezone="UTC")
    Date createdDate ;
    @Column(name = "modified_date")
    @LastModifiedDate
    @JsonFormat(timezone="UTC")
    Date modifiedDate ;

    public Conversation(Long id, List<Message> messages) {
        this.id = id;
        this.messages = messages;
    }

    public ConversationDomain toDomain() {
        List<MessageDomain> messages = new ArrayList<>();
        if (!this.messages.equals(null))
            this.messages.forEach(message -> {
                messages.add(message.toDomain());
            });
        return new ConversationDomain(
                this.id,
                messages
        );
    }
}
