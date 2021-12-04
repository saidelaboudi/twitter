package com.twitter.tweet.api.resource;

import com.twitter.socialGraph.api.model.UserAPI;
import com.twitter.tweet.api.model.ReplyAPI;
import com.twitter.tweet.api.model.ReportAPI;
import com.twitter.tweet.api.model.TweetAPI;
import com.twitter.tweet.domain.port.api.ITweetPortToApi;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class TweetController {
    private ITweetPortToApi tweetApiPort;
    @PutMapping("/tweets/{tweetId}/like")
    public void likeTweet(@PathVariable Long tweetId, @RequestBody UserAPI user){
        tweetApiPort.likeTweet(tweetId,user);
    }
    @PutMapping("/tweets/{tweetId}/like")
    public void dislikeTweet(@PathVariable Long tweetId, @RequestBody UserAPI user){
        tweetApiPort.dislikeTweet(tweetId,user);
    }
    @PostMapping("/tweets/create")
    public void creatTweet(@RequestBody TweetAPI tweet){
        tweetApiPort.creatTweet(tweet.toDomain());
    }
    @PutMapping("/tweets/{tweetId}/remove")
    public void removeTweet(@PathVariable Long tweetId){
        tweetApiPort.removeTweet(tweetId);
    }
    @PutMapping("/tweets/{tweetId}/reply")
    public void replyToTweet(@PathVariable Long tweetId,@RequestBody ReplyAPI reply){
        tweetApiPort.replyToTweet(tweetId,reply.toDomain());
    }
    @GetMapping("/tweets/{tweetId}/shares/{userId}")
    public void shareTweet(@PathVariable Long tweetId,@PathVariable Long userId){
        tweetApiPort.shareTweet(tweetId,userId);
    }
    @PutMapping("/tweets/{tweetId}/retweets/users/{userId}")
    public void retweet(@PathVariable Long tweetId,@PathVariable Long userId){
        tweetApiPort.retweet(tweetId,userId);
    }
    @PutMapping("tweets/{tweetId}/reports/{userId}")
    public void reportTweet(@PathVariable Long tweetId,@PathVariable Long userId,@RequestBody ReportAPI report){
        tweetApiPort.reportTweet(tweetId,
                userId,
                report.toDomain());
    }
}
