package com.twitter.homeTimeLine.api.ressource;

import com.twitter.homeTimeLine.domain.port.api.IHomeTimeLineApiPort;
import com.twitter.tweet.api.model.TweetAPI;
import com.twitter.tweet.domain.model.TweetDomain;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/timelines/home")
public class homeTimeLineApi {
    private IHomeTimeLineApiPort homeTimeLine;

    @GetMapping("/users/{userId}/followed/tweets")
    public List<TweetAPI> getTweets(@PathVariable Long userId){
        return homeTimeLine.getAllHomeTimeLineTweets(userId).stream().map(TweetDomain::toAPI).collect(Collectors.toList());
    }
    @GetMapping("/users/{userId}/topics/tweets")
    public List<TweetAPI> getTopicsByFollowedTopics(@PathVariable Long userId){
        return homeTimeLine.getTweetsByFollowedTopicsOfUser(userId).stream().map(TweetDomain::toAPI).collect(Collectors.toList());
    }
}
