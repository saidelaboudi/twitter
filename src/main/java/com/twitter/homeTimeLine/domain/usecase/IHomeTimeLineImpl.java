package com.twitter.homeTimeLine.domain.usecase;

import com.twitter.homeTimeLine.domain.port.api.IHomeTimeLineApiPort;

import java.util.List;

public class IHomeTimeLineImpl implements IHomeTimeLineApiPort {
    @Override
    public List<TweetDomain> seeTweets() {
        return null;
    }
}
