package com.twitter.socialGraph.infra.service.impl;

import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.infra.model.SocialGraph;
import com.twitter.socialGraph.infra.repository.SocialGraphRepository;
import com.twitter.socialGraph.infra.service.ISocialGraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialGraphService implements ISocialGraphService {
    private final SocialGraphRepository socialGraphRepository;

    public SocialGraphService(SocialGraphRepository socialGraphRepository) {
        this.socialGraphRepository = socialGraphRepository;
    }

    @Override
    public SocialGraph update(SocialGraph socialGraph) {
        return socialGraphRepository.save(socialGraph);
    }

    @Override
    public SocialGraph findSocialGraphByOwner(UserDomain currentUser) {
        return currentUser.toInfra().getSocialGraph();
    }
}
