package com.twitter.tweet.domain.model;

import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.tweet.infra.model.Report;
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

    public Report toInfra() {
        return new Report(
                this.id,
                this.message,
                this.user.toInfra()
        );
    }
}
