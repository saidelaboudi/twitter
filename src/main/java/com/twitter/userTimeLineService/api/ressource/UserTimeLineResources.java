package com.twitter.userTimeLineService.api.ressource;

import com.twitter.tweet.api.model.TweetAPI;
import com.twitter.tweet.domain.model.TweetDomain;
import com.twitter.tweet.domain.port.api.ITweetPortToApi;
import com.twitter.userTimeLineService.domain.port.api.IUserTimeLineApiPort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/userTimeLines")
public class UserTimeLineResources {
    private IUserTimeLineApiPort userTimeLineApiPort;

    @PostMapping("/{userId}/tweets")
    public List<TweetAPI> viewTweetsByUser(@PathVariable Long userId){
        return userTimeLineApiPort.viewTweetsByUser(userId).stream().map(TweetDomain::toAPI).collect(Collectors.toList());
    }

    @PostMapping("/{userId}/tweets/likedTweets")
    public List<TweetAPI> viewLikedTweetsByUser(@PathVariable Long userId){
        return userTimeLineApiPort.getLinkedTweetsByUser(userId).stream().map(TweetDomain::toAPI).collect(Collectors.toList());
    }

    @PostMapping("/{userId}/tweets/reTweets-commentedTweets")
    public List<TweetAPI> viewReTweetsAndCommentedTweetsByUser(@PathVariable Long userId){
        return null;
    }

}
