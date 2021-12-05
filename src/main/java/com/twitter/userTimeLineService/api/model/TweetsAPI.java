package com.twitter.userTimeLineService.api.model;

import com.twitter.userTimeLineService.domain.model.TweetsDomain;

import java.io.File;

public class TweetsAPI {
    private Long userId;
    private Long tweetID;
    private Long tweetOwnerID;
    private String tweetContent;
    private File tweetMedia;

    public TweetsAPI(Long userId, Long tweetID, Long tweetOwnerID, String tweetContent, File tweetMedia) {
        this.userId = userId;
        this.tweetID = tweetID;
        this.tweetOwnerID = tweetOwnerID;
        this.tweetContent = tweetContent;
        this.tweetMedia = tweetMedia;
    }

    public TweetsDomain toDomain(){
        return new TweetsDomain(userId, tweetID, tweetOwnerID, tweetContent, tweetMedia);
    }

}
