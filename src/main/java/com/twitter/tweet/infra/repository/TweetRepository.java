package com.twitter.tweet.infra.repository;

import com.twitter.directMessage.infra.model.Reaction;
import com.twitter.tweet.infra.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet,Long> {
    List<Tweet> findTweetsByTextContains(String keyword);
    Tweet findByReactionsContaining(Reaction reaction);
}
