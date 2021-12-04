package com.twitter.tweet.domain.model;

import com.twitter.socialGraph.domain.model.UserDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportDomain {
    private Long id;
    private String message;
    private UserDomain user;
}
