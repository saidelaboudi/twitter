package com.twitter.directMessage.api.model;

import com.twitter.directMessage.domain.model.ReactionDomain;
import com.twitter.socialGraph.api.model.UserAPI;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReactionAPI {
    private Long id;
    private UserAPI user = new UserAPI();

    public ReactionDomain toDomain() {
        return new ReactionDomain(
                this.id,
                this.user.toDomain()
        );
    }
}
