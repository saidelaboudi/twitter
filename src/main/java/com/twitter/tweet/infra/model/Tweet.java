package com.twitter.tweet.infra.model;

import com.twitter.directMessage.domain.model.ReactionDomain;
import com.twitter.directMessage.infra.model.Reaction;
import com.twitter.socialGraph.infra.model.User;
import com.twitter.tweet.domain.model.ReplyDomain;
import com.twitter.tweet.domain.model.ReportDomain;
import com.twitter.tweet.domain.model.TweetDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private User owner;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reaction> reactions;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reply> replies;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Report> reports;

    public TweetDomain toDomain() {
        List<ReactionDomain> reactions =new ArrayList<>();
        List<ReplyDomain> replies =new ArrayList<>();
        List<ReportDomain> reports =new ArrayList<>();
        if (!this.reactions.equals(null))
            this.reactions.forEach(reaction->{
            reactions.add(reaction.toDomain());
        });
        if (!this.replies.equals(null))
            this.replies.forEach(reply->{
            replies.add(reply.toDomain());
        });
        if (!this.reports.equals(null))
            this.reports.forEach(report->{
            reports.add(report.toDomain());
        });
        return new TweetDomain(
                this.id,
                this.owner.toDomain(),
                reactions,
                replies,
                reports
        );
    }
}
