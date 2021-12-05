package com.twitter.userTimeLineService.domain.port.infra;

import com.twitter.userTimeLineService.domain.model.TweetsDomain;

import java.util.List;

public interface IUserTimeLineInfraPort {

    public List<TweetsDomain> getTweetsByUser(String userName);
    public List<TweetsDomain> getLikedTweetsByUser(String userName);
    public List<TweetsDomain> getReTweetsAndCommentedTweetsByUser(String userName);

}
