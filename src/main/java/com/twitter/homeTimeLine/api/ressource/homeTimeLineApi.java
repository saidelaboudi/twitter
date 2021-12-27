package com.twitter.homeTimeLine.api.ressource;

import com.twitter.homeTimeLine.domain.port.api.IHomeTimeLineApiPort;
import com.twitter.searchService.domain.port.api.ISearchServiceApi;
import com.twitter.tweet.api.model.TweetAPI;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api")
public class HomeTimeLineApi {
    private IHomeTimeLineApiPort homeTimeLinePort;
    private ISearchServiceApi searchServiceApi;

    @PostMapping("/home/timelines/users/{userId}")
    public List<TweetAPI> viewTweets(@PathVariable Long userId) {
        return homeTimeLinePort.getAllHomeTimeLineTweets(userId).stream().map(it -> it.toAPI()).collect(Collectors.toList());
    }

    @PostMapping("/exploreTweetsByFilter/{keyword}")
    public List<TweetAPI> exploreTweetsByFilter(@PathVariable String keyword) {
        return searchServiceApi.searchByKeyword(keyword).stream().map(it -> it.toAPI()).collect(Collectors.toList());
    }
}
