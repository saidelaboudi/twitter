package com.twitter.tweet.api.model;

import com.twitter.tweet.domain.model.ReplyDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyAPI {
    public ReplyDomain toDomain() {
        return null;
    }
}
