package com.twitter.userTimeLineService.domain.usecase;

import com.twitter.directMessage.domain.model.ReactionDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.domain.port.service.IUserTweeterPort;
import com.twitter.tweet.domain.model.TweetDomain;
import com.twitter.tweet.domain.port.api.ITweetPortToApi;
import com.twitter.tweet.domain.port.infra.IReactionInfraPort;
import com.twitter.tweet.domain.port.infra.ITweetPortToInfra;
import com.twitter.userTimeLineService.domain.port.api.IUserTimeLineApiPort;

import java.util.ArrayList;
import java.util.List;

public class userTimeLine implements IUserTimeLineApiPort {

    private ITweetPortToInfra portToInfra;
    private IUserTweeterPort userInfraPort;
    private IReactionInfraPort reactionInfraPort;

    @Override
    public List<TweetDomain> viewTweetsByUser(Long userId) {
        return portToInfra.getTweetsByUser(userId);
    }

    @Override
    public List<TweetDomain> viewReTweetsAndCommentedTweetsByUser(Long userId) {
        return null;
    }

    @Override
    public List<TweetDomain> getLinkedTweetsByUser(Long userId) {
        UserDomain user = userInfraPort.findUserById(userId);
        List<ReactionDomain> reactions = reactionInfraPort.getTweetsReactedByUser(user);
        List<TweetDomain> likedTweets = new ArrayList<>();
        reactions.forEach(reaction -> {
            likedTweets.add(portToInfra.getLikedTweetsByUserReaction(reaction.toInfra()));
        });
        return likedTweets;
    }
}
