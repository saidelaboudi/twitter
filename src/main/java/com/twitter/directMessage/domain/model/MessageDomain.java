package com.twitter.directMessage.domain.model;

import com.twitter.directMessage.api.model.MessageAPI;
import com.twitter.directMessage.api.model.ReactionAPI;
import com.twitter.directMessage.infra.model.Message;
import com.twitter.directMessage.infra.model.Reaction;
import com.twitter.socialGraph.domain.model.UserDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDomain {
    private Long id;
    private UserDomain sender;
    private String message;
    private List<ReactionDomain> reactions;

    public MessageAPI toApi() {
        List<ReactionAPI> reactions = new ArrayList<>();
        if (!this.reactions.equals(null))
            this.reactions.forEach(reaction -> {
                reactions.add(reaction.toAPI());
            });
        return new MessageAPI(
                this.id,
                this.sender.toAPI(),
                this.message,
                reactions
        );
    }

    public Message toInfra() {
        List<Reaction> reactions = new ArrayList<>();
        if (!this.reactions.equals(null))
            this.reactions.forEach(reaction -> {
            reactions.add(reaction.toInfra());
        });
        return new Message(this.id, this.sender.toInfra(), this.message, reactions);
    }

    public void addReaction(ReactionDomain reaction) {
        reactions.add(reaction);
    }
}
