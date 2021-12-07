package com.twitter.userTimeLineService.domain.usecase;

import com.twitter.tweet.domain.model.TweetDomain;
import com.twitter.userTimeLineService.domain.port.api.IUserTimeLineApiPort;

import java.util.List;

public class userTimeLine {

    private IUserTimeLineApiPort tweetsPort;

    /**
     *
     * @param userName
     * @return list of tweets created by the user
     */
    public List<TweetDomain> viewTweets(String userName){
        return tweetsPort.viewTweetsByUser(userName);
    }

    /**
     *
     * @param userName
     * @return list of retweets and commented tweets by the user
     */
    public List<TweetDomain> viewRespondedTweets(String userName){
        return tweetsPort.viewReTweetsAndCommentedTweetsByUser(userName);
    }

    /**
     *
     * @param userName
     * @return list of liked tweets by the user
     */
    public List<TweetDomain> viewLikedTweets(String userName){
        return tweetsPort.viewLikedTweetsByUser(userName);
    }

}
