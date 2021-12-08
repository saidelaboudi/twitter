package com.twitter.userTimeLineService.infra.service.impl;

import com.twitter.directMessage.infra.model.Reaction;
import com.twitter.socialGraph.infra.model.User;
import com.twitter.userTimeLineService.infra.repository.ReactionRepository;
import com.twitter.userTimeLineService.infra.service.IReactionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReactionService implements IReactionService {
    @Autowired
    private ReactionRepository reactionRepository;

    @Override
    public List<Reaction> getTweetsReactedByUser(User user) {
        return reactionRepository.findByUser(user);
    }
}
