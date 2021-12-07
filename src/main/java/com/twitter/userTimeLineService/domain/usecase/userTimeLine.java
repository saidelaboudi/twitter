package com.twitter.userTimeLineService.domain.usecase;

import com.twitter.tweet.domain.model.TweetDomain;
import com.twitter.userTimeLineService.domain.port.api.IUserTimeLineApiPort;

import java.util.List;

public class userTimeLine {

    private IUserTimeLineApiPort tweetsPort;

    /**
     *
     * @param userId
     * @return list of tweets created by the user
     */
    public List<TweetDomain> viewTweets(Long userId){
        return tweetsPort.viewTweetsByUser(userId);
    }

    /**
     *
     * @param userId
     * @return list of retweets and commented tweets by the user
     */
    public List<TweetDomain> viewRespondedTweets(Long userId){
        return tweetsPort.viewReTweetsAndCommentedTweetsByUser(userId);
    }

    /**
     *
     * @param userId
     * @return list of liked tweets by the user
     */
    public List<TweetDomain> viewLikedTweets(Long userId){
        return tweetsPort.viewLikedTweetsByUser(userId);
    }

}
