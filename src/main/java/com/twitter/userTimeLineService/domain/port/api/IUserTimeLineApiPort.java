package com.twitter.userTimeLineService.domain.port.api;

import com.twitter.userTimeLineService.domain.model.TweetsDomain;

import java.util.List;

public interface IUserTimeLineApiPort {
    public List<TweetsDomain> viewTweetsByUser(String userName);
    public List<TweetsDomain> viewLikedTweetsByUser(String userName);
    public List<TweetsDomain> viewReTweetsAndCommentedTweetsByUser(String userName);
}
