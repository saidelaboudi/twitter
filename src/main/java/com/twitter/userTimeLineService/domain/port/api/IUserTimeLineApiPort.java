package com.twitter.userTimeLineService.domain.port.api;

import com.twitter.tweet.domain.model.TweetDomain;

import java.util.List;
import java.util.Optional;

public interface IUserTimeLineApiPort {

    List<TweetDomain> viewTweetsByUser(Long userId);

    List<TweetDomain> getLinkedTweetsByUser(Long userId);

    List<TweetDomain> viewReTweetsAndCommentedTweetsByUser(Long userId);
}
