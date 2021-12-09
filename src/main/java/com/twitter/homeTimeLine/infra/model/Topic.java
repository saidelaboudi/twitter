package com.twitter.homeTimeLine.infra.model;

import com.twitter.homeTimeLine.domain.model.TopicDomain;
import com.twitter.tweet.infra.model.Tweet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Tweet> tweets ;

    public TopicDomain toDomain() {
        return new TopicDomain(
                this.id,
                this.tweets.stream().map(Tweet::toDomain).collect(Collectors.toList())
        );
    }
}
