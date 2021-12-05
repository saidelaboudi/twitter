package com.twitter.userTimeLineService.domain.usecase;

import com.twitter.userTimeLineService.domain.model.TweetsDomain;
import com.twitter.userTimeLineService.domain.port.infra.IUserTimeLineInfraPort;

import java.util.List;

public class userTimeLine {

    private IUserTimeLineInfraPort tweetsPort;

    /**
     *
     * @param userName
     * @return list of tweets created by the user
     */
    public List<TweetsDomain> getTweets(String userName){
        return tweetsPort.getTweetsByUser(userName);
    }

    /**
     *
     * @param userName
     * @return list of retweets and commented tweets by the user
     */
    public List<TweetsDomain> viewRespondedTweets(String userName){
        return tweetsPort.getReTweetsAndCommentedTweetsByUser(userName);
    }

    /**
     *
     * @param userName
     * @return list of liked tweets by the user
     */
    public List<TweetsDomain> getLikedTweets(String userName){
        return tweetsPort.getLikedTweetsByUser(userName);
    }

}
