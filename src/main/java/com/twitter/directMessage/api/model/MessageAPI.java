package com.twitter.directMessage.api.model;

import com.twitter.directMessage.domain.model.GroupDomain;
import com.twitter.directMessage.domain.model.MessageDomain;
import com.twitter.directMessage.domain.model.ReactionDomain;
import com.twitter.socialGraph.api.model.UserAPI;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageAPI {
    private Long id;
    private UserAPI sender = new UserAPI();
    private String message;
    private List<ReactionAPI> reactions = new ArrayList<ReactionAPI>();

    public MessageDomain toDomain() {
        List<ReactionDomain> reactions = new ArrayList<>();
        if (!this.reactions.equals(null))
            this.reactions.forEach(reaction -> {
                reactions.add(reaction.toDomain());
            });
        return new MessageDomain(this.id, this.sender.toDomain(), this.message, reactions);
    }
}
