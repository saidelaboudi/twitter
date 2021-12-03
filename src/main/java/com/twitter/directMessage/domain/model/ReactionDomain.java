package com.twitter.directMessage.domain.model;

import com.twitter.directMessage.api.model.ReactionAPI;
import com.twitter.directMessage.infra.model.REACTION_TYPE;
import com.twitter.directMessage.infra.model.Reaction;
import com.twitter.socialGraph.domain.model.UserDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReactionDomain {
    private Long id;
    private UserDomain user;
    private REACTION_TYPE reaction;

    public ReactionAPI toAPI() {
        return new ReactionAPI(
                this.id,
                this.user.toAPI(),
                this.reaction
        );
    }

    public Reaction toInfra() {
        return new Reaction(
          this.id,
          this.user.toInfra(),
          this.reaction
        );
    }
}
