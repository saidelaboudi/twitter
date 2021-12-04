package com.twitter.tweet.domain.model;

import com.twitter.directMessage.domain.model.ReactionDomain;
import com.twitter.directMessage.infra.model.Reaction;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.tweet.infra.model.Reply;
import com.twitter.tweet.infra.model.Report;
import com.twitter.tweet.infra.model.Tweet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
        List<Reaction> reactions =new ArrayList<>();
        List<Reply> replies =new ArrayList<>();
        List<Report> reports =new ArrayList<>();
        this.reactions.forEach(reaction->{
            reactions.add(reaction.toInfra());
        });
        this.replies.forEach(reply->{
            replies.add(reply.toInfra());
        });
        this.reports.forEach(report->{
            reports.add(report.toInfra());
        });
        return new Tweet(
                this.id,
                this.owner.toInfra(),
                reactions,
                replies,
                reports
        );
    }

    public TweetDomain toDomain() {
        return null;
    }
}
