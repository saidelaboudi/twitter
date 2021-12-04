package com.twitter.directMessage.infra.model;

import com.twitter.directMessage.domain.model.ConversationDomain;
import com.twitter.directMessage.domain.model.MessageDomain;
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
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Message> messages;

    public ConversationDomain toDomain() {
        List<MessageDomain> messages = new ArrayList<>();
        this.messages.forEach(message->{
            messages.add(message.toDomain());
        });
        return new ConversationDomain(
                this.id,
                messages
        );
    }
}
