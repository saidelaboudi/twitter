package com.twitter.userTimeLineService.domain.model;

import com.twitter.userTimeLineService.api.model.TweetsAPI;

import java.io.File;

public class TweetsDomain {

    private Long userId;
    private Long tweetID;
    private Long tweetOwnerID;
    private String tweetContent;
    private File tweetMedia;

    public TweetsDomain(Long userId, Long tweetID, Long tweetOwnerID, String tweetContent, File tweetMedia) {
        this.userId = userId;
        this.tweetID = tweetID;
        this.tweetOwnerID = tweetOwnerID;
        this.tweetContent = tweetContent;
        this.tweetMedia = tweetMedia;
    }

    public TweetsAPI toAPI(){
        return new TweetsAPI(userId, tweetID, tweetOwnerID, tweetContent, tweetMedia);
    }
}
