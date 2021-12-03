package com.twitter.socialGraph.infra.service.impl;

import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.infra.model.SocialGraph;
import com.twitter.socialGraph.infra.repository.SocialGraphRepository;
import com.twitter.socialGraph.infra.service.ISocialGraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialGraphService implements ISocialGraphService {
    @Autowired
    private SocialGraphRepository socialGraphRepository;
    @Override
    public SocialGraph update(SocialGraph socialGraph) {
        return socialGraphRepository.save(socialGraph);
    }

    @Override
    public SocialGraph findSocialGraphByOwner(UserDomain currentUserDomain) {
        return socialGraphRepository.findByOwner(currentUserDomain.toInfra());
    }
}
