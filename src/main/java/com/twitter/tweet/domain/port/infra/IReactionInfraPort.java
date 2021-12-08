package com.twitter.tweet.domain.port.infra;

import com.twitter.directMessage.domain.model.ReactionDomain;
import com.twitter.socialGraph.domain.model.UserDomain;

import java.util.List;

public interface IReactionInfraPort {
    List<ReactionDomain> getTweetsReactedByUser(UserDomain user);
}
