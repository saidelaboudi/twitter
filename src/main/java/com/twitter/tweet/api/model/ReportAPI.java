package com.twitter.tweet.api.model;

import com.twitter.socialGraph.api.model.UserAPI;
import com.twitter.tweet.domain.model.ReportDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportAPI {
    private Long id;
    private String message;
    private UserAPI user;
    public ReportDomain toDomain() {
        return null;
    }
}
