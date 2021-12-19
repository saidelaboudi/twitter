package com.twitter.tweet.infra.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.twitter.directMessage.domain.model.ReactionDomain;
import com.twitter.directMessage.infra.model.Reaction;
import com.twitter.socialGraph.infra.model.User;
import com.twitter.tweet.domain.model.ReplyDomain;
import com.twitter.tweet.domain.model.ReportDomain;
import com.twitter.tweet.domain.model.TweetDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
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
    private String text;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reaction> reactions;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reply> replies;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Report> reports;
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    @JsonFormat(timezone="UTC")
    Date createdDate ;
    @Column(name = "modified_date")
    @LastModifiedDate
    @JsonFormat(timezone="UTC")
    Date modifiedDate ;

    public Tweet(Long id, User owner, String text, List<Reaction> reactions, List<Reply> replies, List<Report> reports) {
        this.id = id;
        this.owner = owner;
        this.text = text;
        this.reactions = reactions;
        this.replies = replies;
        this.reports = reports;
    }

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
                this.text,
                reactions,
                replies,
                reports
        );
    }
}
