package com.twitter.userTimeLineService.infra.service;

import com.twitter.directMessage.domain.model.ReactionDomain;
import com.twitter.directMessage.infra.model.Reaction;
import com.twitter.socialGraph.infra.model.User;

import java.util.List;

public interface IReactionService {
    List<Reaction> getTweetsReactedByUser(User user);
}
