package com.twitter.tweet.api.model;

import com.twitter.socialGraph.api.model.UserAPI;
import com.twitter.tweet.domain.model.ReplyDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyAPI {
    private Long id;
    private String message;
    private UserAPI user;
    public ReplyDomain toDomain() {
        return new ReplyDomain(
                this.id,
                this.message,
                this.user.toDomain()
        );
    }
}
