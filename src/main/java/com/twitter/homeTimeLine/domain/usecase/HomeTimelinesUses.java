package com.twitter.homeTimeLine.domain.usecase;

import com.twitter.homeTimeLine.domain.model.TopicDomain;
import com.twitter.homeTimeLine.domain.port.api.IHomeTimeLineApiPort;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.domain.port.infra.IUserInfraPort;
import com.twitter.tweet.domain.model.TweetDomain;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class HomeTimelinesUses implements IHomeTimeLineApiPort {
    @Autowired
    private IUserInfraPort userInfraPort;
    @Override
    public List<TweetDomain> getAllHomeTimeLineTweets(Long userId) {
        UserDomain user = userInfraPort.findUserById(userId);
        List<UserDomain> followedUsers =userInfraPort.getAllUsers ();//.getFollowed();
        List<TweetDomain> tweets =  new ArrayList<TweetDomain>();
        followedUsers.forEach(u->{
            tweets.addAll(
                    u.getTweets()
            );
        });
        return tweets;
    }

    @Override
    public List<TweetDomain> getTweetsByFollowedTopicsOfUser(Long userId) {
        UserDomain user = userInfraPort.findUserById(userId);
        List<TopicDomain> topics = user.getTopics();
        List<TweetDomain> allTweets = new ArrayList<>();
        topics.forEach(topic->{
            allTweets.addAll(
                    topic.getTweets()
            );
        });
        return allTweets;
    }
}
