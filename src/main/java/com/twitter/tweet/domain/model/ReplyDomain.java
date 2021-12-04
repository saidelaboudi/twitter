package com.twitter.tweet.domain.model;

import com.twitter.socialGraph.api.model.UserAPI;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.tweet.infra.model.Reply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDomain {
    private Long id;
    private String message;
    private UserDomain user;

    public Reply toInfra() {
        return new Reply(
                this.id,
                this.message,
                this.user.toInfra()
        );
    }
}
