package com.twitter.userTimeLineService.infra.model;

import com.twitter.userTimeLineService.domain.model.TweetsDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.File;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tweetID;

    private Long userID;

    @OneToOne
    private Long ownerID;

    private String tweetContent;

    @OneToOne
    private String mediaPath;

    public TweetsDomain toDomain(){
        return new TweetsDomain(userID, tweetID, userID,tweetContent, new File(mediaPath));
    }
}
