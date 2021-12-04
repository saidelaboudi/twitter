package com.twitter.tweet.domain.model;

import com.twitter.directMessage.domain.model.ReactionDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.tweet.infra.model.Tweet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TweetDomain {
    private Long id;
    private UserDomain owner;
    private List<ReactionDomain> reactions;
    private List<ReplyDomain> replies;
    private List<ReportDomain> reports;

    public void addReaction(ReactionDomain dislike) {
        this.reactions.add(dislike);
    }

    public void addReply(ReplyDomain reply) {
        this.replies.add(reply);
    }

    public void report(UserDomain user, ReportDomain report) {
        this.reports.add(report);
    }

    public Tweet toInfra() {
        return new Tweet();
    }
}
