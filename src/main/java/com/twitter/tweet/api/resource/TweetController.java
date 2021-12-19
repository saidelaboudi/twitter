package com.twitter.tweet.api.resource;

import com.twitter.tweet.api.model.ReplyAPI;
import com.twitter.tweet.api.model.ReportAPI;
import com.twitter.tweet.api.model.TweetAPI;
import com.twitter.tweet.domain.port.api.ITweetPortToApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class TweetController {
    @Autowired
    private ITweetPortToApi tweetApiPort;

    public TweetController(ITweetPortToApi tweetApiPort) {
        this.tweetApiPort = tweetApiPort;
    }

    @PutMapping("/users/{userId}/tweets/{tweetId}/like")
    public void likeTweet(@PathVariable Long tweetId, @PathVariable Long userId) {
        tweetApiPort.likeTweet(tweetId, userId);
    }

    @PutMapping("/users/{userId}/tweets/{tweetId}/dislike")
    public void dislikeTweet(@PathVariable Long tweetId, @PathVariable Long userId) {
        tweetApiPort.dislikeTweet(tweetId, userId);
    }

    @PostMapping("/users/{userId}/tweets/create")
    public void createTweet(@RequestBody TweetAPI tweet, @PathVariable Long userId) {
        System.out.println(tweet.toString());
        System.out.println(userId);
        tweetApiPort.createTweet(tweet.toDomain(), userId);
    }

    @PutMapping("/tweets/{tweetId}/remove")
    public void removeTweet(@PathVariable Long tweetId) {
        tweetApiPort.removeTweet(tweetId);
    }

    @PutMapping("/tweets/{tweetId}/reply")
    public void replyToTweet(@PathVariable Long tweetId, @RequestBody ReplyAPI reply) {
        tweetApiPort.replyToTweet(tweetId, reply.toDomain());
    }

    @GetMapping("/user/{userId}/shares/tweets/{tweetId}/")
    public void shareTweet(@PathVariable Long tweetId, @PathVariable Long userId) {
        tweetApiPort.shareTweet(tweetId, userId);
    }

    @PutMapping("/users/{userId}/retweets/{tweetId}/")
    public void retweet(@PathVariable Long tweetId, @PathVariable Long userId) {
        tweetApiPort.retweet(tweetId, userId);
    }

    @PutMapping("/users/{userId}/tweets/{tweetId}/reports")
    public void reportTweet(@PathVariable Long tweetId, @PathVariable Long userId, @RequestBody ReportAPI report) {
        tweetApiPort.reportTweet(tweetId, report.toDomain());
    }
}
