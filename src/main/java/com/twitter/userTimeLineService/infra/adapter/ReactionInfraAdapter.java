package com.twitter.userTimeLineService.infra.adapter;

import com.twitter.directMessage.domain.model.ReactionDomain;
import com.twitter.directMessage.infra.model.Reaction;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.tweet.domain.port.infra.IReactionInfraPort;
import com.twitter.userTimeLineService.infra.service.IReactionService;

import java.util.List;
import java.util.stream.Collectors;

public class ReactionInfraAdapter implements IReactionInfraPort {
    private IReactionService reactionService;
    @Override
    public List<ReactionDomain> getTweetsReactedByUser(UserDomain user) {
        return reactionService.getTweetsReactedByUser(user.toInfra()).stream().map(Reaction::toDomain).collect(Collectors.toList());
    }
}
