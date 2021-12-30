package com.twitter.tweet.infra.model;

import com.twitter.directMessage.infra.model.Reaction;
import com.twitter.socialGraph.infra.model.User;
import com.twitter.tweet.domain.model.TweetDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reaction> reactions;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reply> replies;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Report> reports;

    public TweetDomain toDomain() {
        return new TweetDomain(
                this.id,
                this.text,
                this.reactions.size()>0 ? null : this.reactions.stream().map(Reaction::toDomain).collect(Collectors.toList()),
                this.replies==null ? null : this.replies.stream().map(Reply::toDomain).collect(Collectors.toList()),
                this.reports==null ? null : this.reports.stream().map(Report::toDomain).collect(Collectors.toList())
        );
    }
}
