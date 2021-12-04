package com.twitter.directMessage.domain.model;

import com.twitter.directMessage.api.model.ConversationAPI;
import com.twitter.directMessage.api.model.MessageAPI;
import com.twitter.directMessage.infra.model.Conversation;
import com.twitter.directMessage.infra.model.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversationDomain {
    private Long id;
    private List<MessageDomain> messages;


    public Conversation toInfra() {
        List<Message> messages = new ArrayList<>();
        this.messages.forEach(message->{
            messages.add(message.toInfra());
        });
        return new Conversation(
                this.id,
                messages
        );
    }

    public ConversationAPI toApi() {
        List<MessageAPI> messages = new ArrayList<>();
        this.messages.forEach(message->{
            messages.add(message.toApi());
        });
        return new ConversationAPI(
                this.id,
                messages
        );
    }
}
