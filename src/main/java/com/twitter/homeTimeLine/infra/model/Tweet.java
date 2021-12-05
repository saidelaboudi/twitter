package com.twitter.homeTimeLine.infra.model;

import com.twitter.homeTimeLine.domain.model.TweetDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    public TweetDomain toDomain() {

        return new TweetDomain(

        );
    }
}
