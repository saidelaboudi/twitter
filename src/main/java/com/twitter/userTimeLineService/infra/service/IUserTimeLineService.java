package com.twitter.userTimeLineService.infra.service;

import com.twitter.userTimeLineService.domain.model.TweetsDomain;
import com.twitter.userTimeLineService.infra.model.Tweet;

import java.util.List;

public interface IUserTimeLineService {
    public List<Tweet> getTweetsByUser(String userName);
    public List<Tweet> getLikedTweetsByUser(String userName);
    public List<Tweet> getReTweetsAndCommentedTweetsByUser(String userName);
}
