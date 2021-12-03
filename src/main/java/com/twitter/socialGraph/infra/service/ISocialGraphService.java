package com.twitter.socialGraph.infra.service;

import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.infra.model.SocialGraph;

public interface ISocialGraphService {
    SocialGraph update(SocialGraph socialGraph);

    SocialGraph findSocialGraphByOwner(UserDomain currentUserDomain);
}
