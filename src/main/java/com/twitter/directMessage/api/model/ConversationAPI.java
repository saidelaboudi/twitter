package com.twitter.directMessage.api.model;

import com.twitter.directMessage.domain.model.ConversationDomain;
import com.twitter.directMessage.domain.model.MessageDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversationAPI {
    private Long id;
    private List<MessageAPI> messages = new ArrayList<MessageAPI>();

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
