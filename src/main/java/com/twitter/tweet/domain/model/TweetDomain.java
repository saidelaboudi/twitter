package com.twitter.tweet.domain.model;

import com.twitter.directMessage.api.model.ReactionAPI;
import com.twitter.directMessage.domain.model.ReactionDomain;
import com.twitter.directMessage.infra.model.Reaction;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.tweet.api.model.ReplyAPI;
import com.twitter.tweet.api.model.ReportAPI;
import com.twitter.tweet.api.model.TweetAPI;
import com.twitter.tweet.infra.model.Reply;
import com.twitter.tweet.infra.model.Report;
import com.twitter.tweet.infra.model.Tweet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TweetDomain {
    private Long id;
    private String text;
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
        return new Tweet(
                this.id,
                this.text,
                this.reactions==null ? null : this.reactions.stream().map(ReactionDomain::toInfra).collect(Collectors.toList()),
                this.replies==null ? null : this.replies.stream().map(it -> it.toInfra()).collect(Collectors.toList()),
                this.reports==null ? null : this.reports.stream().map(it -> it.toInfra()).collect(Collectors.toList())
        );
    }

    public TweetAPI toAPI() {
        return new TweetAPI(
                this.id,
                this.text,
                this.reactions==null ? null : this.reactions.stream().map(it -> it.toAPI()).collect(Collectors.toList()),
                this.replies==null ? null : this.replies.stream().map(it -> it.toAPI()).collect(Collectors.toList()),
                this.reports==null ? null : this.reports.stream().map(it -> it.toAPI()).collect(Collectors.toList())
        );
    }
}
