package com.twitter.homeTimeLine.api.ressource;

import com.twitter.homeTimeLine.domain.port.api.IHomeTimeLineApiPort;
import com.twitter.searchService.domain.port.api.ISearchServiceApi;
import com.twitter.tweet.api.model.TweetAPI;
import com.twitter.tweet.domain.model.TweetDomain;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class HomeTimeLineApi {
    private IHomeTimeLineApiPort homeTimeLinePort;
    private ISearchServiceApi searchServiceApi;
    @PostMapping("/home/timelines/users/{userId}")
    public List<TweetAPI> viewTweets(@PathVariable Long userId){
        return homeTimeLinePort.getAllHomeTimeLineTweets(userId);
    }
    @PostMapping("/exploreTweetsByFilter/{keyword}")
    public List<TweetDomain> exploreTweetsByFilter(@PathVariable String keyword){
        return searchServiceApi.searchByKeyword(keyword);
    }
    @PostMapping("/seeTopics")
    public void seeTopics(){
    }
}
