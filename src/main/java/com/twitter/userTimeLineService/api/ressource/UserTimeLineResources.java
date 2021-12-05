package com.twitter.userTimeLineService.api.ressource;

import com.twitter.userTimeLineService.api.model.TweetsAPI;
import com.twitter.userTimeLineService.domain.model.TweetsDomain;
import com.twitter.userTimeLineService.domain.port.api.IUserTimeLineApiPort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/api/userTimeLine")
public class UserTimeLineResources {
    private IUserTimeLineApiPort userTimeLineApiPort;

    @PostMapping("/{userName}")
    public List<TweetsAPI> viewTweetsByUser(String userName){
        List<TweetsAPI> tweets = new ArrayList<TweetsAPI>();
        userTimeLineApiPort.viewTweetsByUser(userName).forEach(tweet->{
            tweets.add(tweet.toAPI());
        });

        return tweets;
    }

    @PostMapping("/likedTweets/{userName}")
    public List<TweetsAPI> viewLikedTweetsByUser(String userName){
        return null;
    }

    @PostMapping("/reTweets-commentedTweets/{userName}")
    public List<TweetsAPI> viewReTweetsAndCommentedTweetsByUser(String userName){
        return null;
    }

}
