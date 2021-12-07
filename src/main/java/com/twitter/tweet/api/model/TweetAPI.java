package com.twitter.tweet.api.model;

import com.twitter.directMessage.api.model.ReactionAPI;
import com.twitter.directMessage.domain.model.ReactionDomain;
import com.twitter.socialGraph.api.model.UserAPI;
import com.twitter.tweet.domain.model.ReplyDomain;
import com.twitter.tweet.domain.model.ReportDomain;
import com.twitter.tweet.domain.model.TweetDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TweetAPI {
    private Long id;
    private UserAPI owner = new UserAPI();
    private List<ReactionAPI> reactions = new ArrayList<ReactionAPI>();
    private List<ReplyAPI> replies=new ArrayList<ReplyAPI>();
    private List<ReportAPI> reports=new ArrayList<ReportAPI>();

    public TweetDomain toDomain() {
        List<ReactionDomain> reactions = new ArrayList<>();
        List<ReplyDomain> replies = new ArrayList<>();
        List<ReportDomain> reports = new ArrayList<>();
        this.reactions.forEach(reaction -> {
            if (!reaction.equals(null))
                reactions.add(reaction.toDomain());
        });
        this.replies.forEach(reply -> {
            if (!reply.equals(null))
                replies.add(reply.toDomain());
        });
        this.reports.forEach(reaction -> {
            if (!reaction.equals(null))
                reports.add(reaction.toDomain());
        });
        return new TweetDomain(this.id, this.owner.toDomain(), reactions, replies, reports);
    }
}
