package com.twitter.userTimeLineService.api.ressource;

import com.twitter.tweet.api.model.TweetAPI;
import com.twitter.tweet.domain.port.api.ITweetPortToApi;
import com.twitter.userTimeLineService.domain.port.api.IUserTimeLineApiPort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/api/userTimeLines")
public class UserTimeLineResources {
    private ITweetPortToApi userTimeLineApiPort;

    @PostMapping("/{userId}/tweets")
    public List<TweetAPI> viewTweetsByUser(Long userId){
        List<TweetAPI> tweets = new ArrayList<TweetAPI>();
        userTimeLineApiPort.viewTweetsByUser(userId).forEach(tweet->{
            tweets.add((TweetAPI) tweet.toAPI());
        });

        return tweets;
    }

    @PostMapping("/{userId}/tweets/likedTweets")
    public List<TweetAPI> viewLikedTweetsByUser(Long userId){
        return null;
    }

    @PostMapping("/{userId}/tweets/reTweets-commentedTweets")
    public List<TweetAPI> viewReTweetsAndCommentedTweetsByUser(Long userName){
        return null;
    }

}
